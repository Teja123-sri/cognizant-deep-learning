--Exercise 7: Packages

--Scenario 1: Group all customer-related procedures and functions into a package.

--package creation
CREATE OR REPLACE PACKAGE CustomerManagement AS
  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER);
  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER);
  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER;
END CustomerManagement;
/

--package body creation
CREATE OR REPLACE PACKAGE BODY CustomerManagement AS

  PROCEDURE AddCustomer(p_id NUMBER, p_name VARCHAR2, p_dob DATE, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_id, p_name, p_dob, p_balance, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Customer added: ' || p_name);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Customer ID already exists.');
  END;

  PROCEDURE UpdateCustomer(p_id NUMBER, p_name VARCHAR2, p_balance NUMBER) IS
  BEGIN
    UPDATE Customers
    SET Name = p_name, Balance = p_balance, LastModified = SYSDATE
    WHERE CustomerID = p_id;

    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No customer found to update.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Customer updated successfully.');
    END IF;
  END;

  FUNCTION GetCustomerBalance(p_id NUMBER) RETURN NUMBER IS
    v_balance NUMBER;
  BEGIN
    SELECT Balance INTO v_balance FROM Customers WHERE CustomerID = p_id;
    RETURN v_balance;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END;

END CustomerManagement;
/

--testing
BEGIN
  CustomerManagement.AddCustomer(10, 'Test User', TO_DATE('2000-01-01','YYYY-MM-DD'), 1000);
  DBMS_OUTPUT.PUT_LINE('Balance: ' || CustomerManagement.GetCustomerBalance(10));
END;
/




--Scenario 2: Create a package to manage employee data.

--package creation
CREATE OR REPLACE PACKAGE EmployeeManagement AS
  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hiredate DATE);
  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER);
  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER;
END EmployeeManagement;
/

--package body creation
CREATE OR REPLACE PACKAGE BODY EmployeeManagement AS

  PROCEDURE HireEmployee(p_id NUMBER, p_name VARCHAR2, p_position VARCHAR2, p_salary NUMBER, p_dept VARCHAR2, p_hiredate DATE) IS
  BEGIN
    INSERT INTO Employees(EmployeeID, Name, Position, Salary, Department, HireDate)
    VALUES(p_id, p_name, p_position, p_salary, p_dept, p_hiredate);
    DBMS_OUTPUT.PUT_LINE('Employee hired: ' || p_name);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Employee ID already exists.');
  END;

  PROCEDURE UpdateEmployee(p_id NUMBER, p_salary NUMBER) IS
  BEGIN
    UPDATE Employees
    SET Salary = p_salary
    WHERE EmployeeID = p_id;

    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No employee found to update.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Employee salary updated.');
    END IF;
  END;

  FUNCTION GetAnnualSalary(p_id NUMBER) RETURN NUMBER IS
    v_salary NUMBER;
  BEGIN
    SELECT Salary INTO v_salary FROM Employees WHERE EmployeeID = p_id;
    RETURN v_salary * 12;
  EXCEPTION
    WHEN NO_DATA_FOUND THEN
      RETURN NULL;
  END;

END EmployeeManagement;
/

--testing
BEGIN
  EmployeeManagement.HireEmployee(10, 'Teja', 'Analyst', 60000, 'Finance', SYSDATE);
  DBMS_OUTPUT.PUT_LINE('Annual Salary: ' || EmployeeManagement.GetAnnualSalary(10));
END;
/




--Scenario 3: Group all account-related operations into a package.

--package creation
CREATE OR REPLACE PACKAGE AccountOperations AS
  PROCEDURE OpenAccount(p_id NUMBER, p_custid NUMBER, p_type VARCHAR2, p_balance NUMBER);
  PROCEDURE CloseAccount(p_id NUMBER);
  FUNCTION GetTotalBalance(p_custid NUMBER) RETURN NUMBER;
END AccountOperations;
/

--package body creation
CREATE OR REPLACE PACKAGE BODY AccountOperations AS

  PROCEDURE OpenAccount(p_id NUMBER, p_custid NUMBER, p_type VARCHAR2, p_balance NUMBER) IS
  BEGIN
    INSERT INTO Accounts(AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES(p_id, p_custid, p_type, p_balance, SYSDATE);
    DBMS_OUTPUT.PUT_LINE('Account opened for Customer ID: ' || p_custid);
  EXCEPTION
    WHEN DUP_VAL_ON_INDEX THEN
      DBMS_OUTPUT.PUT_LINE('Account ID already exists.');
  END;

  PROCEDURE CloseAccount(p_id NUMBER) IS
  BEGIN
    DELETE FROM Accounts WHERE AccountID = p_id;

    IF SQL%ROWCOUNT = 0 THEN
      DBMS_OUTPUT.PUT_LINE('No account found to close.');
    ELSE
      DBMS_OUTPUT.PUT_LINE('Account closed: ' || p_id);
    END IF;
  END;

  FUNCTION GetTotalBalance(p_custid NUMBER) RETURN NUMBER IS
    v_total NUMBER := 0;
  BEGIN
    SELECT SUM(Balance) INTO v_total FROM Accounts WHERE CustomerID = p_custid;
    RETURN NVL(v_total, 0);
  END;

END AccountOperations;
/

--testing
BEGIN
  AccountOperations.OpenAccount(10, 1, 'Savings', 5000);
  DBMS_OUTPUT.PUT_LINE('Total Balance: ' || AccountOperations.GetTotalBalance(1));
END;
/

