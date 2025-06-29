--Exercise 1: Control Structures

--Scenario 1: The bank wants to apply a discount to loan interest rates for customers above 60 years old.

BEGIN
  FOR c IN (
    SELECT c.CustomerID, c.Name, c.DOB, l.LoanID, l.InterestRate
    FROM Customers c
    JOIN Loans l ON c.CustomerID = l.CustomerID
  ) LOOP
    IF TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60 THEN
      UPDATE Loans
      SET InterestRate = InterestRate - 1
      WHERE LoanID = c.LoanID;

      DBMS_OUTPUT.PUT_LINE('1% discount applied to Loan ID ' || c.LoanID ||
                           ' for customer ' || c.Name);
    END IF;
  END LOOP;
  COMMIT;
END;
/



--Scenario 2: A customer can be promoted to VIP status based on their balance.

BEGIN
  FOR c IN (
    SELECT CustomerID, Name FROM Customers WHERE Balance > 10000
  ) LOOP
    UPDATE Customers
    SET IsVIP = 'Y'
    WHERE CustomerID = c.CustomerID;

    DBMS_OUTPUT.PUT_LINE(c.Name || ' promoted to VIP!');
  END LOOP;
  COMMIT;
END;
/


--Scenario 3: The bank wants to send reminders to customers whose loans are due within the next 30 days.

BEGIN
  FOR l IN (
    SELECT l.LoanID, l.EndDate, c.Name
    FROM Loans l
    JOIN Customers c ON c.CustomerID = l.CustomerID
    WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('REMAINDER: Loan ID ' || l.LoanID || ' for customer ' || l.Name ||
                         ' is due on ' || TO_CHAR(l.EndDate, 'YYYY-MM-DD'));
  END LOOP;
END;
/
