CREATE TABLE sessional_exam (
    student_id NUMBER PRIMARY KEY,
    sub1 NUMBER,
    sub2 NUMBER,
    sub3 NUMBER,
    total_marks NUMBER
);

INSERT INTO sessional_exam (student_id, sub1, sub2, sub3) 
VALUES (1, 80, 90, 85);

INSERT INTO sessional_exam (student_id, sub1, sub2, sub3) 
VALUES (2, 75, 80, 95);

INSERT INTO sessional_exam (student_id, sub1, sub2, sub3) 
VALUES (3, 88, 92, 78);

COMMIT;
SELECT * FROM sessional_exam;


SET SERVEROUTPUT ON;

CREATE OR REPLACE PROCEDURE calculate_total IS
BEGIN
    UPDATE sessional_exam
    SET total_marks = sub1 + sub2 + sub3;

    COMMIT;
END calculate_total;
/


BEGIN
    calculate_total;

    DBMS_OUTPUT.PUT_LINE('Total marks for all students have been updated.');
END;
/

SELECT * FROM sessional_exam;

/*
Sample Input/Output:

STUDENT_ID   SUB1   SUB2   SUB3   TOTAL_MARKS
-----------  -----  -----  -----  ------------
          1    80     90     85          
          2    75     80     95          
          3    88     92     78          

Total marks for all students have been updated.

STUDENT_ID   SUB1   SUB2   SUB3   TOTAL_MARKS
-----------  -----  -----  -----  ------------
          1    80     90     85          255
          2    75     80     95          250
          3    88     92     78          258
*/