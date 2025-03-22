SET SERVEROUTPUT ON;

DECLARE
    a NUMBER := &a;
    b NUMBER := &b;

BEGIN
    DBMS_OUTPUT.PUT_LINE(a || ' + ' || b || ' = ' || (a+b));
END;
/

/*
Sample Input/Output:

Enter value for a: old   2:     a NUMBER := &a;
new   2:     a NUMBER := 10;
Enter value for b: old   3:     b NUMBER := &b;
new   3:     b NUMBER := 15;

10 + 15 = 25
*/