--Exercise 4: Functions

--Scenario 1: Calculate the age of customers for eligibility checks.

CREATE OR REPLACE FUNCTION CalculateAge(dob DATE)
RETURN NUMBER
IS
  age_years NUMBER;
BEGIN
  age_years := FLOOR(MONTHS_BETWEEN(SYSDATE, dob) / 12);
  RETURN age_years;
END;
/

SELECT Name, CalculateAge(DOB) AS Age FROM Customers;


--Scenario 2: The bank needs to compute the monthly installment for a loan.

CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment(
  loan_amount NUMBER,
  annual_interest_rate NUMBER,
  duration_years NUMBER
)
RETURN NUMBER
IS
  monthly_rate NUMBER;
  total_months NUMBER;
  emi NUMBER;
BEGIN
  monthly_rate := annual_interest_rate / 12 / 100;
  total_months := duration_years * 12;

  IF monthly_rate = 0 THEN
    emi := loan_amount / total_months;
  ELSE
    emi := loan_amount * monthly_rate * POWER(1 + monthly_rate, total_months)
           / (POWER(1 + monthly_rate, total_months) - 1);
  END IF;

  RETURN ROUND(emi, 2);
END;
/

SELECT CalculateMonthlyInstallment(100000, 6, 5) AS EMI FROM dual;


--Scenario 3: Check if a customer has sufficient balance before making a transaction.

CREATE OR REPLACE FUNCTION HasSufficientBalance(
  input_account_id NUMBER,
  required_amount NUMBER
)
RETURN BOOLEAN
IS
  current_balance NUMBER;
BEGIN
  SELECT Balance INTO current_balance
  FROM Accounts
  WHERE AccountID = input_account_id;

  RETURN current_balance >= required_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/

DECLARE
  result BOOLEAN;
BEGIN
  result := HasSufficientBalance(2, 5000);
  IF result THEN
    DBMS_OUTPUT.PUT_LINE('Sufficient balance.');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Insufficient balance.');
  END IF;
END;
/

