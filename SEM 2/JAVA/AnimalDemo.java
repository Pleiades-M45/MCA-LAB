abstract class Animal{
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
        System.out.println("Species: " + species + "\nWeight: " + weight + " Kg"+ "\nAge: " + age + "\nColor: " + color);
    }
}
class Dog extends Animal {
    private String name, owner;

    public Dog(String s, int w, int a, String c, String name, String owner){
        super(s, w, a, c);
        this.name = name;
        this.owner = owner;
    }
    public void display() {
        super.display();
        System.out.println("Name: " + name + "\nOwned By: " + owner + "\n");
    }
}

class Cat extends Animal {
    private String name, eyecolor;
    int tail_length;

    public Cat(String name, String eyecolor, int tail_length){
        super("Persian", 15, 3, "Grey");
        this.name = name;
        this.eyecolor = eyecolor;
        this.tail_length = tail_length;
    }
    public void display(){
        super.display();
        System.out.println("Name: " + name + "\nEyecolor: " + eyecolor + "\nTail Length: " + tail_length + "cm");
    }
}
public class AnimalDemo{
    public static void main(String[] args){
        Animal a;

        a = new Dog("Samoyed", 20, 2, "White", "Wooyoo", "Aether");
        a.display();

        a = new Cat("Luna", "Silver", 30);
        a.display();
    }
}