SET SERVEROUTPUT ON;
DECLARE
    num NUMBER := &num;
    fact NUMBER := 1;
BEGIN
    FOR i IN 1..num LOOP
        fact := fact * i;
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Factorial of ' || num || ' is ' || fact);
END;
/

/*
Sample Input/Output:

Enter value for num: old   2:     num NUMBER := &num;
new   2:     num NUMBER := 4;

Factorial of 4 is 24
*/