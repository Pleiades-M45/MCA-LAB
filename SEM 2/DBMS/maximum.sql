SET SERVEROUTPUT ON;

DECLARE
    a NUMBER;
    b NUMBER;
    max_value NUMBER;
BEGIN

    DBMS_OUTPUT.PUT_LINE('Enter first value:');
    a := &a; 
    
    DBMS_OUTPUT.PUT_LINE('Enter second value:');
    b := &b; 
    
    IF a > b THEN
        max_value := a;
    ELSE
        max_value := b;
    END IF;

    DBMS_OUTPUT.PUT_LINE('Maximum value is: ' || max_value);
END;
/
