CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(20),
    department VARCHAR2(20)
);

INSERT INTO employees (employee_id, employee_name, department)
VALUES (1, 'Paimon', 'Sales');

INSERT INTO employees (employee_id, employee_name, department)
VALUES (2, 'Aether', 'HR');

INSERT INTO employees (employee_id, employee_name, department)
VALUES (3, 'Diluc', 'HR');

INSERT INTO employees (employee_id, employee_name, department)
VALUES (4, 'Lumine', 'Sales');

INSERT INTO employees (employee_id, employee_name, department)
VALUES (5, 'Childe', 'Sales');

COMMIT;
SELECT * FROM employees;


SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE count_employees (
    p_dep_name IN VARCHAR2, 
    p_emp_count OUT NUMBER  
) IS
BEGIN
    SELECT COUNT(*) 
    INTO p_emp_count
    FROM employees
    WHERE department = p_dep_name;
    
END count_employees;
/


DECLARE
    v_emp_count NUMBER;
    dep VARCHAR2(20);
BEGIN
    dep := '&dep'; 

    count_employees(dep, v_emp_count);
    
    DBMS_OUTPUT.PUT_LINE('Number of employees in ' || dep || ': ' || v_emp_count);
END;
/

/*
Sample Input/Output:

EMPLOYEE_ID  EMPLOYEE_NAME         DEPARTMENT
------------ --------------------  --------------------
         1   Paimon                Sales
         2   Aether                HR
         3   Diluc                 HR
         4   Lumine                Sales
         5   Childe                Sales     

Enter value for dep: old   5:     dep := '&dep';
new   5:     dep := 'Sales';

Number of employees in Sales: 3
*/