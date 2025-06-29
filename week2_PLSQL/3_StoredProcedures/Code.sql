--Exercise 3: Stored Procedures

--Scenario 1: The bank needs to process monthly interest for all savings accounts.

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
  FOR acc IN (
    SELECT AccountID, Balance
    FROM Accounts
    WHERE AccountType = 'Savings'
  ) LOOP
    UPDATE Accounts
    SET Balance = acc.Balance + (acc.Balance * 0.01),
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

    DBMS_OUTPUT.PUT_LINE(
      'Interest applied to Account ID: ' || acc.AccountID || 
      ' | Old Balance: ' || acc.Balance || 
      ' | New Balance: ' || (acc.Balance + acc.Balance * 0.01)
    );
  END LOOP;

  COMMIT;
END;
/

BEGIN
  ProcessMonthlyInterest;
END;
/


--Scenario 2: The bank wants to implement a bonus scheme for employees based on their performance.

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus(
  dept_name IN VARCHAR2,
  bonus_percent IN NUMBER
) AS
BEGIN
  FOR emp IN (
    SELECT EmployeeID, Name, Salary
    FROM Employees
    WHERE Department = dept_name
  ) LOOP
    UPDATE Employees
    SET Salary = emp.Salary + (emp.Salary * bonus_percent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE(
      'Bonus applied to ' || emp.Name || 
      ' (ID: ' || emp.EmployeeID || ') | Old Salary: ' || emp.Salary ||
      ' | New Salary: ' || (emp.Salary + emp.Salary * bonus_percent / 100)
    );
  END LOOP;

  COMMIT;
END;
/

BEGIN
    -- 10% bonus to IT department employees
    UpdateEmployeeBonus('IT', 10); 
END;
/


--Scenario 3: Customers should be able to transfer funds between their accounts.

CREATE OR REPLACE PROCEDURE TransferFunds(
  sender_account_id   IN NUMBER,
  receiver_account_id IN NUMBER,
  transfer_amount     IN NUMBER
) AS
  sender_current_balance NUMBER;
BEGIN
  -- Fetch sender's current balance
  SELECT Balance INTO sender_current_balance
  FROM Accounts
  WHERE AccountID = sender_account_id
  FOR UPDATE;

  -- Check if sender has enough balance
  IF sender_current_balance < transfer_amount THEN
    RAISE_APPLICATION_ERROR(-20003, 'Transfer failed: Insufficient balance in sender account.');
  END IF;

  -- Deduct amount from sender
  UPDATE Accounts
  SET Balance = Balance - transfer_amount
  WHERE AccountID = sender_account_id;

  -- Add amount to receiver
  UPDATE Accounts
  SET Balance = Balance + transfer_amount
  WHERE AccountID = receiver_account_id;

  COMMIT;

  DBMS_OUTPUT.PUT_LINE('Transfer of ' || transfer_amount ||
                       ' completed from Account ' || sender_account_id ||
                       ' to Account ' || receiver_account_id || '.');
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Error during fund transfer: ' || SQLERRM);
END;
/
BEGIN
  TransferFunds(sender_account_id => 2, receiver_account_id => 4, transfer_amount => 1000);
END;
/

BEGIN
  TransferFunds(sender_account_id => 5, receiver_account_id => 1, transfer_amount => 500);
END;
/
