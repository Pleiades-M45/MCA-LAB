class Zoo {
    String name, encl[];

    public Zoo(String name, String[] encl) {
        this.name = name;
        this.encl = encl;
    }

    public void displayZoo() {
        System.out.println("Name: " + name);
        for (String x : encl)
            System.out.println(x);
    }

    class Enclosure {
        String name, type, animals[];

        public Enclosure(String n, String t, String[] a) {
            name = n;
            type = t;
            animals = a;
        }

        public void displayEnclosure() {
            System.out.println("\nName: " + name + ", Type: " + type);
            for (String x : animals)
                System.out.println(x);
        }
    }

    static class ZooInfo {
        String addr, phno;

        public ZooInfo(String a, String p) {
            addr = a;
            phno = p;
        }

        public void displayZooInfo() {
            System.out.println("Address: " + addr + ", Phone Number: " + phno);
        }
    }
}

public class ZooDemo {
    public static void main(String[] args) {
        String enclosures[] = {"Savannah", "Rainforest", "Aquarium"};
        
        String animalsInSavannah[] = {"Lion", "Elephant", "Cheetah"};
        String animalsInRainforest[] = {"Monkey", "Toucan", "Jaguar"};
        String animalsInAquarium[] = {"Sharks", "Turtles", "Clownfish"};

        // Creating the Zoo object with a real zoo name
        Zoo z = new Zoo("Orcaland Zoo", enclosures);

        // Creating the Enclosure objects with real animal names
        Zoo.Enclosure savannah = z.new Enclosure("Savannah", "Outdoor", animalsInSavannah);
        Zoo.Enclosure rainforest = z.new Enclosure("Rainforest", "Indoor", animalsInRainforest);
        Zoo.Enclosure aquarium = z.new Enclosure("Aquarium", "Indoor", animalsInAquarium);

        Zoo.ZooInfo info = new Zoo.ZooInfo("Orcaland, Iceland", "1234567890");

        z.displayZoo();
        savannah.displayEnclosure();
        rainforest.displayEnclosure();
        aquarium.displayEnclosure();
        info.displayZooInfo();
    }
}

/*
Sample Input/Output:

Name: Orcaland Zoo
Savannah
Rainforest
Aquarium

Name: Savannah, Type: Outdoor
Lion
Elephant
Cheetah

Name: Rainforest, Type: Indoor
Monkey
Toucan
Jaguar

Name: Aquarium, Type: Indoor
Sharks
Turtles
Clownfish
Address: Orcaland, Iceland, Phone Number: 1234567890
 */