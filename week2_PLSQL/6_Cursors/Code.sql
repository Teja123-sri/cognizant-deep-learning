--Exercise 6: Cursors

--Scenario 1: Generate monthly statements for all customers.

DECLARE
  CURSOR txn_cursor IS
    SELECT t.TransactionID, t.AccountID, c.Name, t.TransactionType, t.Amount, t.TransactionDate
    FROM Transactions t
    JOIN Accounts a ON t.AccountID = a.AccountID
    JOIN Customers c ON a.CustomerID = c.CustomerID
    WHERE EXTRACT(MONTH FROM t.TransactionDate) = EXTRACT(MONTH FROM SYSDATE)
      AND EXTRACT(YEAR FROM t.TransactionDate) = EXTRACT(YEAR FROM SYSDATE);
BEGIN
  FOR txn IN txn_cursor LOOP
    DBMS_OUTPUT.PUT_LINE('Statement - Customer: ' || txn.Name || 
                         ', AccountID: ' || txn.AccountID || 
                         ', Transaction: ' || txn.TransactionType || 
                         ', Amount: ' || txn.Amount || 
                         ', Date: ' || TO_CHAR(txn.TransactionDate, 'DD-MON-YYYY'));
  END LOOP;
END;
/



--Scenario 2: Apply annual fee to all accounts.

DECLARE
  CURSOR acc_cursor IS
    SELECT AccountID, Balance FROM Accounts FOR UPDATE;
  annual_fee NUMBER := 500; 
BEGIN
  FOR acc IN acc_cursor LOOP
    UPDATE Accounts
    SET Balance = Balance - annual_fee,
        LastModified = SYSDATE
    WHERE AccountID = acc.AccountID;

    DBMS_OUTPUT.PUT_LINE('Annual fee of ' || annual_fee || 
                         ' applied to Account ID ' || acc.AccountID);
  END LOOP;
  COMMIT;
END;
/



--Scenario 3: Update the interest rate for all loans based on a new policy.

DECLARE
  CURSOR loan_cursor IS
    SELECT LoanID, LoanAmount, InterestRate FROM Loans FOR UPDATE;
  new_rate NUMBER;
BEGIN
  FOR loan IN loan_cursor LOOP
    IF loan.LoanAmount > 10000 THEN
      new_rate := loan.InterestRate + 1;
    ELSE
      new_rate := loan.InterestRate + 0.5;
    END IF;

    UPDATE Loans
    SET InterestRate = new_rate
    WHERE LoanID = loan.LoanID;

    DBMS_OUTPUT.PUT_LINE('Loan ID ' || loan.LoanID || 
                         ' updated interest to ' || new_rate || '%');
  END LOOP;
  COMMIT;
END;
/
