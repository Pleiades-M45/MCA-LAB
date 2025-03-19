SET SERVEROUTPUT ON;

DECLARE
    a NUMBER := &a;
    b NUMBER := &b;
summ NUMBER;

BEGIN
summ := a+b;
    DBMS_OUTPUT.PUT_LINE(a || ' + ' || b || ' = ' || summ);
END;
/
