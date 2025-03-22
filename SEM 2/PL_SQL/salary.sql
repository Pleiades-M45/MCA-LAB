CREATE TABLE employees (
    employee_id NUMBER PRIMARY KEY,
    employee_name VARCHAR2(20),
    salary NUMBER
);

INSERT INTO employees (employee_id, employee_name, salary)
VALUES (101, 'Paimon', 50000);

INSERT INTO employees (employee_id, employee_name, salary)
VALUES (102, 'Aether', 60000);

INSERT INTO employees (employee_id, employee_name, salary)
VALUES (103, 'Lumine', 45000);

COMMIT;
SELECT * FROM employees;


SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION update_salary(
    p_emp_id IN NUMBER, 
    p_percentage IN NUMBER
) 
RETURN VARCHAR2
IS
    v_old_sal employees.salary%TYPE;
    v_new_sal employees.salary%TYPE; 
BEGIN

    SELECT salary
    INTO v_old_sal
    FROM employees
    WHERE employee_id = p_emp_id;

    v_new_sal := v_old_sal + (v_old_sal * p_percentage / 100);

    UPDATE employees
    SET salary = v_new_sal
    WHERE employee_id = p_emp_id;

    COMMIT;

    RETURN ' Updated successfully';
EXCEPTION
    WHEN NO_DATA_FOUND THEN
        RETURN 'Error: Employee not found';
    WHEN OTHERS THEN
        RETURN 'Error: Unable to update salary';
END update_salary;
/


DECLARE
    v_emp_id NUMBER;
    v_percentage NUMBER;
    v_result VARCHAR2(100);
BEGIN
    v_emp_id := &emp_id;
    v_percentage := &percentage;
    
    v_result := update_salary(v_emp_id, v_percentage);
    
    DBMS_OUTPUT.PUT_LINE('Salary for Employee: ' || v_emp_id || v_result);
END;
/

SELECT * FROM employees;

/*
Sample Input/Output:

EMPLOYEE_ID  EMPLOYEE_NAME        SALARY
------------ -------------------- ------------
         101 Paimon               50000
         102 Aether               60000
         103 Lumine               45000

Enter value for emp_id: old   6:     v_emp_id := &emp_id;
new   6:     v_emp_id := 101;
Enter value for percentage: old   7:     v_percentage := &percentage;
new   7:     v_percentage := 10;

Salary for Employee: 101 Updated successfully

EMPLOYEE_ID  EMPLOYEE_NAME        SALARY
------------ -------------------- ------------
         101 Paimon               55000
         102 Aether               60000
         103 Lumine               45000
*/