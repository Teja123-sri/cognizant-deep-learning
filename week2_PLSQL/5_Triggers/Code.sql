--Exercise 5: Triggers

--Scenario 1: Automatically update the last modified date when a customer's record is updated.

CREATE OR REPLACE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
  :NEW.LastModified := SYSDATE;
END;
/

--updating balance 
UPDATE Customers
SET Balance = Balance + 500
WHERE CustomerID = 1;

--checking if trigger is working
SELECT Name, Balance, TO_CHAR(LastModified, 'YYYY-MM-DD HH24:MI:SS') AS LastModified
FROM Customers
WHERE CustomerID = 1;



--Scenario 2: Maintain an audit log for all transactions.

CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
  INSERT INTO AuditLog(AccountID, Action, Amount, LogDate)
  VALUES(:NEW.AccountID, :NEW.TransactionType, :NEW.Amount, SYSDATE);
END;
/

--inserting 
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (6, 1, SYSDATE, 400, 'Deposit');

--checking trigger working
SELECT * FROM AuditLog;



--Scenario 3: Enforce business rules on deposits and withdrawals.

CREATE OR REPLACE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
DECLARE
  acc_balance NUMBER;
BEGIN
  SELECT Balance INTO acc_balance FROM Accounts WHERE AccountID = :NEW.AccountID;

  IF :NEW.TransactionType = 'Withdrawal' THEN
    IF :NEW.Amount > acc_balance THEN
      RAISE_APPLICATION_ERROR(-20001, 'Withdrawal amount exceeds current account balance.');
    END IF;
  ELSIF :NEW.TransactionType = 'Deposit' THEN
    IF :NEW.Amount <= 0 THEN
      RAISE_APPLICATION_ERROR(-20002, 'Deposit amount must be positive.');
    END IF;
  END IF;
END;
/

--withdrawl amt is larger than current amt
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (10, 5, SYSDATE, 500, 'Withdrawal');
--deposit amt is negative
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType) VALUES (23, 2, SYSDATE, -500, 'Deposit');
