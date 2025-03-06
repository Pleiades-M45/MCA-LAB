import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

class Attendee {
    String name, email;
    int regid;

    public Attendee(String n, String e, int r) {
        name = n;
        email = e;
        regid = r;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attendee at = (Attendee) o;
        return regid == at.regid;
    }

    @Override
    public int hashCode() {
        return Objects.hash(regid);
    }

    @Override
    public String toString() {
        return "Registration ID: " + regid + ", Name: " + name + ", Email: " + email;
    }
}

public class HashSetAttendee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Attendee> at = new HashSet<>();
        
        System.out.print("Enter the number of attendees: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Attendee #" + (i + 1) + ":");
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Email: ");
            String email = sc.nextLine();

            System.out.print("Registration ID: ");
            int regid = sc.nextInt();
            sc.nextLine();

            Attendee newAttendee = new Attendee(name, email, regid);
            at.add(newAttendee);
        }

        System.out.println("\nUnique Attendees:");
        for (Attendee x : at) {
            System.out.println(x);
        }

        sc.close();
    }
}

/*
Sample Input/Output:

Enter the number of attendees: 3

Enter details for Attendee #1:
Name: Paimon
Email: paimon@email.com  
Registration ID: 1

Enter details for Attendee #2:
Name: Aether
Email: aether@email.com
Registration ID: 2

Enter details for Attendee #3:
Name: Paimon Duplicate
Email: paimon@duplicate.com
Registration ID: 1

Unique Attendees:
Registration ID: 1, Name: Paimon, Email: paimon@email.com
Registration ID: 2, Name: Aether, Email: aether@email.com
*/