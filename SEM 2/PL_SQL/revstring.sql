SET SERVEROUTPUT ON;

CREATE OR REPLACE FUNCTION reverse_string(in_str IN VARCHAR2) 
RETURN VARCHAR2
IS
    rev_str VARCHAR2(100) := ''; 
BEGIN

    FOR i IN REVERSE 1..LENGTH(in_str) LOOP
        rev_str := rev_str || SUBSTR(in_str, i, 1);
    END LOOP;
    
    RETURN rev_str;
END;
/

DECLARE
    in_str VARCHAR2(100);
    rev_str VARCHAR2(100);
BEGIN

    in_str := '&in_str'; 
    rev_str := reverse_string(in_str);

    DBMS_OUTPUT.PUT_LINE('Original String: ' || in_str);
    DBMS_OUTPUT.PUT_LINE('Reversed String: ' || rev_str);
END;
/

/*
Sample Input/Output:

Enter value for in_str: old   6:     in_str := '&in_str';
new   6:     in_str := 'Hello';

Original String: Hello
Reversed String: olleH
*/