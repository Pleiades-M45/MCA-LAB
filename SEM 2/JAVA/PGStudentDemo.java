import java.util.Scanner;

interface Showable {
    void show();
}

class Person implements Showable {
    private String name, gender;
    int phoneno;

    public Person(String name, String gender, int phoneno) {
        this.name = name;
        this.gender = gender;
        this.phoneno = phoneno;
    }

    @Override
    public void show() {
        System.out.println("Name = " + name + "\nGender = " + gender + "\nPhone No = " + phoneno);
    }
}

class Student extends Person {
    String course;
    double score;

    public Student(String name, String gender, int phoneno, String course, double score) {
        super(name, gender, phoneno);
        this.course = course;
        this.score = score;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Course = " + course + "\nScore = " + score);
    }
}

class PGStudent extends Student {
    String researchArea, guide;

    public PGStudent(String name, String gender, int phoneno, String course, double score, String researchArea, String guide) {
        super(name, gender, phoneno, course, score);
        this.researchArea = researchArea;
        this.guide = guide;
    }

    @Override
    public void show() {
        super.show();
        System.out.println("Research Area = " + researchArea + "\nGuide = " + guide);
    }
}

public class PGStudentDemo {

    static void sortPGStudents(PGStudent[] pg) {
        int n = pg.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                // Sort by Score (Descending)
                if (pg[j].score < pg[j + 1].score) {
                    PGStudent temp = pg[j];
                    pg[j] = pg[j + 1];
                    pg[j + 1] = temp;
                }
                // If Scores are equal, sort by Research Area (Alphabetical)
                else if (pg[j].score == pg[j + 1].score) {
                    if (pg[j].researchArea.compareTo(pg[j + 1].researchArea) > 0) {
                        PGStudent temp = pg[j];
                        pg[j] = pg[j + 1];
                        pg[j + 1] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of PG Students: ");
        int n = sc.nextInt();
        sc.nextLine();

        PGStudent[] pg = new PGStudent[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Gender: ");
            String gender = sc.nextLine();

            System.out.print("Phone No: ");
            int phoneno = sc.nextInt();
            sc.nextLine();

            System.out.print("Course: ");
            String course = sc.nextLine();

            System.out.print("Score: ");
            double score = sc.nextDouble();
            sc.nextLine();

            System.out.print("Research Area: ");
            String researchArea = sc.nextLine();

            System.out.print("Guide: ");
            String guide = sc.nextLine();

            pg[i] = new PGStudent(name, gender, phoneno, course, score, researchArea, guide);
        }

        /*System.out.println("\n\t...Student Details...\n");
        for (PGStudent i : pg) {
            i.show();
            System.out.println("-------------------------");
        }*/
        
        sortPGStudents(pg);

        System.out.println("\n\t...Ranked & Sorted Student Details...\n");
        int rank = 1;
        for (PGStudent student : pg) {
            System.out.println("Rank #" + rank++);
            student.show();
            System.out.println("-------------------------");
        }

        sc.close();
    }
}

/* 
Sample Input/Output:

Enter number of PG Students: 3

Enter details for Student 1:
Name: Kazuha
Gender: Male
Phone No: 1234567890
Course: CS 
Score: 85.5
Research Area: Blockchain
Guide: Dr. Raiden

Enter details for Student 2:
Name: Furina
Gender: Female
Phone No: 9834232322
Course: IT
Score: 90.0
Research Area: Cybersecurity
Guide: Dr. Arlecchino

Enter details for Student 3:
Name: Paimon
Gender: Female
Phone No: 1231453453
Course: CS
Score: 85.5
Research Area: AI
Guide: Dr. Aether

        ...Ranked & Sorted Student Details...

Rank #1
Name = Furina
Gender = Female
Phone No = 9834232322
Course = IT
Score = 90.0
Research Area = Cybersecurity
Guide = Dr. Arlecchino
-------------------------
Rank #2
Name = Paimon
Gender = Female
Phone No = 1231453453
Course = CS
Score = 85.5
Research Area = AI
Guide = Dr. Aether
-------------------------
Rank #3
Name = Kazuha
Gender = Male
Phone No = 1234567890
Course = CS
Score = 85.5
Research Area = Blockchain
Guide = Dr. Raiden
-------------------------
*/