class CPU{
    int price;

    public CPU(int p){
        price = p;
    }
    public void displayCPU(){
        System.out.println("CPU Price: " + price);
    }

    class Processor{
        int cores_no;
        String manufact;

        public Processor(int c, String m){
            cores_no = c;
            manufact = m;
        }
        public void displayProcessor(){
            System.out.println("Processor Cores: " + cores_no + ", Manufacturer: " + manufact);
        }
    }

    static class RAM{
        int memory;
        String manufact;

        public RAM(int mem, String m){
            memory = mem;
            manufact = m;
        }
        public void displayRAM(){
            System.out.println("RAM: " + memory + " GB, Manufactured by " + manufact);
        }
    }
}

public class CPUDemo{
    public static void main(String[] args) {
        CPU c = new CPU(1000);
        c.displayCPU();
        c.new Processor(4, "AMD").displayProcessor();
        new CPU.RAM(16, "Corsair").displayRAM();
    }
}

/*
Sample Input/Output:

CPU Price: 1000
Processor Cores: 4, Manufacturer: AMD
RAM: 16 GB, Manufactured by Corsair
 */