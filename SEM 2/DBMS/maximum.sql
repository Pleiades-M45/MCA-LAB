SET SERVEROUTPUT ON;

DECLARE
    a NUMBER;
    b NUMBER;
    max_value NUMBER;
BEGIN

    a := &a; 
    b := &b; 
    
    IF a > b THEN
        max_value := a;
    ELSE
        max_value := b;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Maximum value is: ' || max_value);
END;
/

/*
Sample Input/Output:

Enter value for a: old   7:     a := &a;
new   7:     a := 10;
Enter value for b: old   8:     b := &b;
new   8:     b := 20;

Maximum value is: 20
*/