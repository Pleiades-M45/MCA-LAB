import java.util.Scanner;

class Student {
    int rollno, marks[];
    String name;
    static int count = 0;

    public Student(Scanner sc) {
        System.out.print("RollNo: ");
        rollno = sc.nextInt();
        System.out.print("Name: ");
        name = sc.next();
        System.out.println("\tMarks (3 subjects): ");
        marks = new int[3];
        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();
        }
        count++;
    }

    public int total() {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += marks[i];
        }
        return sum;
    }

    public void display() {
        System.out.println("RollNo: " + rollno + "\nName: " + name + "\nMarks: [" + marks[0] + ", " + marks[1] + ", " + marks[2] + "]");
    }
}

public class StudentMain {
    public static void sortStudent(Student ob[]) {
        int n = Student.count;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (ob[i].total() < ob[j].total()) {
                    Student temp = ob[i];
                    ob[i] = ob[j];
                    ob[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("No. of Students: ");
        int n = scanner.nextInt();

        Student[] ob = new Student[n];
        for (int i = 0; i < n; i++) {
            ob[i] = new Student(scanner);
        }

        sortStudent(ob);

        System.out.println("\t---Ranklist---\n");
        for (int i = 0; i < n; i++) {
            ob[i].display();
            System.out.println("Total Marks: " + ob[i].total() + "\n");
        }

        scanner.close();
    }
}
