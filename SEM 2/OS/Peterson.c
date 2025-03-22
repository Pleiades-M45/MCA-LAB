#include <stdio.h>
#include <pthread.h>
#include <stdbool.h>

// Shared variables
volatile int turn;
volatile bool flag[2];  // Two processes: flag[0] for P0, flag[1] for P1

void* process0(void* arg) {
    while (1) {
        // Entry Section
        flag[0] = true;          // Indicate interest to enter critical section
        turn = 1;                // Give turn to process 1

        while (flag[1] && turn == 1) {
            // Busy wait if process 1 wants to enter and it's their turn
        }

        // Critical Section
        printf("Process 0 is in the critical section\n");

        // Exit Section
        flag[0] = false;         // Process 0 is done with the critical section
    }

    return NULL;
}

void* process1(void* arg) {
    while (1) {
        // Entry Section
        flag[1] = true;          // Indicate interest to enter critical section
        turn = 0;                // Give turn to process 0

        while (flag[0] && turn == 0) {
            // Busy wait if process 0 wants to enter and it's their turn
        }

        // Critical Section
        printf("Process 1 is in the critical section\n");

        // Exit Section
        flag[1] = false;         // Process 1 is done with the critical section
    }

    return NULL;
}

int main() {
    pthread_t t0, t1;

    // Initialize flags
    flag[0] = flag[1] = false;
    turn = 0;

    // Create two threads (representing two processes)
    pthread_create(&t0, NULL, process0, NULL);
    pthread_create(&t1, NULL, process1, NULL);

    // Join the threads (in this case, they run indefinitely)
    pthread_join(t0, NULL);
    pthread_join(t1, NULL);

    return 0;
}

/*
Sample Input/Output:

Process 0 is in the critical section
Process 1 is in the critical section
Process 0 is in the critical section
Process 1 is in the critical section
Process 0 is in the critical section
Process 1 is in the critical section
...
*/