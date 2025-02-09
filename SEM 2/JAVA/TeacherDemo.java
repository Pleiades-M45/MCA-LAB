import java.util.Scanner;

class Person {
    protected String name, gender, address;
    protected int age;

    public Person(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }

    public void display() {
        System.out.println("\nName: " + name + "\nGender: " + gender + "\nAddress: " + address + "\nAge: " + age);
    }
}

class Employee extends Person {
    protected int empId;
    protected String companyName, qualification;
    protected double salary;

    public Employee(String name, String gender, String address, int age, int empId, String companyName, String qualification, double salary) {
        super(name, gender, address, age);
        this.empId = empId;
        this.companyName = companyName;
        this.qualification = qualification;
        this.salary = salary;
    }

    public void display() {
        super.display();
        System.out.println("Employee ID: " + empId + "\nCompany: " + companyName + "\nQualification: " + qualification + "\nSalary: $" + salary);
    }
}

class Teacher extends Employee {
    private int teacherId;
    private String subject, department;

    public Teacher(String name, String gender, String address, int age, int empId, String companyName, String qualification, double salary, int teacherId, String subject, String department) {
        super(name, gender, address, age, empId, companyName, qualification, salary);
        this.teacherId = teacherId;
        this.subject = subject;
        this.department = department;
    }

    public void display() {
        super.display();
        System.out.println("Teacher ID: " + teacherId + "\nSubject: " + subject + "\nDepartment: " + department);
    }
}

public class TeacherDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of teachers: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Teacher[] teachers = new Teacher[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");
            
            System.out.print("Name: ");
            String name = sc.nextLine();
            
            System.out.print("Gender: ");
            String gender = sc.nextLine();
            
            System.out.print("Address: ");
            String address = sc.nextLine();
            
            System.out.print("Age: ");
            int age = sc.nextInt();
            
            System.out.print("Employee ID: ");
            int empId = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            System.out.print("Company Name: ");
            String companyName = sc.nextLine();
            
            System.out.print("Qualification: ");
            String qualification = sc.nextLine();
            
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            
            System.out.print("Teacher ID: ");
            int teacherId = sc.nextInt();
            sc.nextLine(); // Consume newline
            
            System.out.print("Subject: ");
            String subject = sc.nextLine();
            
            System.out.print("Department: ");
            String department = sc.nextLine();

            teachers[i] = new Teacher(name, gender, address, age, empId, companyName, qualification, salary, teacherId, subject, department);
        }

        System.out.println("\n\tTeacher Details\n");
        for (Teacher teacher : teachers) {
            teacher.display();
            System.out.println("-------------------------");
        }

        sc.close();
    }
}