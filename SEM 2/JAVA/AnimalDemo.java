import java.util.Scanner;

abstract class Animal {
    private String species;
    int weight, age;
    protected String color;

    public Animal(String s, int w, int a, String c) {
        species = s;
        weight = w;
        age = a;
        color = c;
    }

    public void display() {
        System.out.println(age + " years old " + color + " " + species + " of " + weight + " Kg.");
    }
}

class Dog extends Animal {
    private String name, owner;

    public Dog(String s, int w, int a, String c, String name, String owner) {
        super(s, w, a, c);
        this.name = name;
        this.owner = owner;
    }

    public void display() {
        super.display();
        System.out.println(name + " is owned by " + owner + ".\n");
    }
}

class Cat extends Animal {
    private String name, eyecolor;
    int tail_length;

    public Cat(String s, int w, int a, String c, String name, String eyecolor, int tail_length) {
        super(s, w, a, c);
        this.name = name;
        this.eyecolor = eyecolor;
        this.tail_length = tail_length;
    }

    public void display() {
        super.display();
        System.out.println(name + " has " + eyecolor + " eyes and a " + tail_length + " cm long tail.\n");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Animal a;

        System.out.println("Enter Dog details: Species, Weight, Age, Color, Name, Owner");
        String dSpecies = sc.nextLine();
        int dWeight = sc.nextInt();
        int dAge = sc.nextInt();
        sc.nextLine(); // Consume newline
        String dColor = sc.nextLine();
        String dName = sc.nextLine();
        String dOwner = sc.nextLine();

        System.out.println("Enter Cat details: Species, Weight, Age, Color, Name, Eye Color, Tail Length");
        String cSpecies = sc.nextLine();
        int cWeight = sc.nextInt();
        int cAge = sc.nextInt();
        sc.nextLine(); // Consume newline
        String cColor = sc.nextLine();
        String cName = sc.nextLine();
        String cEyeColor = sc.nextLine();
        int cTailLength = sc.nextInt();

        System.out.println("\n\tAnimal Details\n");
        a = new Dog(dSpecies, dWeight, dAge, dColor, dName, dOwner);
        a.display();

        a = new Cat(cSpecies, cWeight, cAge, cColor, cName, cEyeColor, cTailLength);
        a.display();
    }
}