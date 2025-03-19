SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION update_salary(
    p_emp_id IN NUMBER, 
    p_percentage IN NUMBER
) 
RETURN VARCHAR2
IS
    v_old_salary employees.salary%TYPE;
    v_new_salary employees.salary%TYPE; 
BEGIN

    SELECT salary
    INTO v_old_salary
    FROM employees
    WHERE employee_id = p_emp_id;

    v_new_salary := v_old_salary + (v_old_salary * p_percentage / 100);

    UPDATE employees
    SET salary = v_new_salary
    WHERE employee_id = p_emp_id;

    COMMIT;

    RETURN 'Salary updated successfully';
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
    
    DBMS_OUTPUT.PUT_LINE(v_result);
END;
/
