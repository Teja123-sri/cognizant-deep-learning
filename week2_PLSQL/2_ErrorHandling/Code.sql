--Exercise 2: Error Handling

--Scenario 1: Handle exceptions during fund transfers between accounts.

CREATE OR REPLACE PROCEDURE SafeTransferFunds(
  sender_account_id IN NUMBER,
  receiver_account_id IN NUMBER,
  transfer_amount IN NUMBER
) AS
  sender_balance NUMBER;
BEGIN
  SELECT Balance INTO sender_balance FROM Accounts WHERE AccountID = sender_account_id FOR UPDATE;

  IF sender_balance < transfer_amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds.');
  END IF;

  UPDATE Accounts SET Balance = Balance - transfer_amount WHERE AccountID = sender_account_id;
  UPDATE Accounts SET Balance = Balance + transfer_amount WHERE AccountID = receiver_account_id;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    ROLLBACK;
    DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

BEGIN
  SafeTransferFunds(2, 3, 1000);
END;
/
BEGIN
  SafeTransferFunds(5, 3, 100);
END;
/



--Scenario 2: Manage errors when updating employee salaries.

CREATE OR REPLACE PROCEDURE UpdateSalary(
  emp_id IN NUMBER,
  percent_increase IN NUMBER
) AS
BEGIN
  UPDATE Employees
  SET Salary = Salary + (Salary * percent_increase / 100)
  WHERE EmployeeID = emp_id;

  IF SQL%ROWCOUNT = 0 THEN
    RAISE_APPLICATION_ERROR(-20002, 'Employee ID not found.');
  END IF;

  COMMIT;
EXCEPTION
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('Salary update failed: ' || SQLERRM);
END;
/

BEGIN
  UpdateSalary(emp_id => 3, percent_increase => 10);
END;
/

BEGIN
  UpdateSalary(emp_id => 99, percent_increase => 10);
END;
/



--Scenario 3: Ensure data integrity when adding a new customer.

CREATE OR REPLACE PROCEDURE AddNewCustomer(
  p_customer_id      IN NUMBER,
  p_name             IN VARCHAR2,
  p_dob              IN DATE,
  p_balance          IN NUMBER
) AS
BEGIN
  INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
  VALUES (p_customer_id, p_name, p_dob, p_balance, SYSDATE);

  COMMIT;
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    DBMS_OUTPUT.PUT_LINE('INSERTION FAILED: Customer ID ' || p_customer_id || ' already exists.');
  WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('UNEXPECTED ERROR: ' || SQLERRM);
END;
/

BEGIN
  AddNewCustomer(
    p_customer_id => 6,
    p_name        => 'Frank Valid',
    p_dob         => TO_DATE('1993-04-12', 'YYYY-MM-DD'),
    p_balance     => 3500
  );
END;
/

