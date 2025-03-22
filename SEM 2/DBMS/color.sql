SET SERVEROUTPUT ON;

ACCEPT num NUMBER prompt 'Enter a number between 1 and 3: ';

DECLARE
    num NUMBER := & num; 
    color VARCHAR2(20);
BEGIN

    CASE num
        WHEN 1 THEN color := 'Black';
        WHEN 2 THEN color := 'Blue';
        WHEN 3 THEN color := 'Green';
        ELSE color := 'Invalid number!';
    END CASE;

    DBMS_OUTPUT.PUT_LINE('Color for number ' || num || ' is: ' || color);
END;
/

/*
Sample Input/Output:

Enter a number between 1 and 3: old   2:     num NUMBER := & num;
new   2:     num NUMBER :=	    2;

Color for number 2 is: Blue
*/