class Prime implements Runnable {
    int n = 10;
    
    @Override
    public void run() {
        System.out.println("Prime Numbers(1 to " + n + "): ");
        
        for (int i = 2; i <= n; i++) {
            boolean f = false;
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    f = true;
                    break;
                }
            }
            if(!f){
                System.out.println("Prime: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Even implements Runnable {
    int n = 10;
    
    @Override
    public void run() {
        System.out.println("\tEven Numbers(1 to " + n + "): ");
        
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println("\tEven: " + i);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class Fibo implements Runnable {
    int n = 10, a = 0, b = 1, c = 0;
    
    @Override
    public void run() {
        System.out.println("\t\tFibonacci Numbers(First " + n + "): ");
        
        for (int i = 1; i <= n; i++) {
            System.out.println("\t\tFibonacci: " + c);
            a = b;
            b = c;
            c = a + b;
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreeThreadDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Prime());
        Thread t2 = new Thread(new Even());
        Thread t3 = new Thread(new Fibo());

        t1.start();
        t2.start();
        t3.start();
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("All threads are finished.");
    }
}

/*
Sample Input/Output:

        Even Numbers(1 to 10): 
        Even: 2
Prime Numbers(1 to 10): 
Prime: 2
                Fibonacci Numbers(First 10): 
                Fibonacci: 0
        Even: 4
Prime: 3
                Fibonacci: 1
        Even: 6
Prime: 5
                Fibonacci: 1
        Even: 8
Prime: 7
                Fibonacci: 2
        Even: 10
                Fibonacci: 3
                Fibonacci: 5
                Fibonacci: 8
                Fibonacci: 13
                Fibonacci: 21
                Fibonacci: 34
All threads are finished.
*/