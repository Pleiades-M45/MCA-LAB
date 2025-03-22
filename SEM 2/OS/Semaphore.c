#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>  // For sleep()

// Semaphore for mutual exclusion
sem_t mutex;

void* process0(void* arg) {
    while (1) {
        // Entry Section
        sem_wait(&mutex);  // Wait (decrease semaphore to enter critical section)

        // Critical Section
        printf("Process 0 is in the critical section\n");

        // Exit Section
        sem_post(&mutex);  // Signal (release semaphore after leaving critical section)

        // Add a small delay to allow the other process to execute
        usleep(100);  // Sleep for 100 microseconds
    }

    return NULL;
}

void* process1(void* arg) {
    while (1) {
        // Entry Section
        sem_wait(&mutex);  // Wait (decrease semaphore to enter critical section)

        // Critical Section
        printf("Process 1 is in the critical section\n");

        // Exit Section
        sem_post(&mutex);  // Signal (release semaphore after leaving critical section)

        // Add a small delay to allow the other process to execute
        usleep(100);  // Sleep for 100 microseconds
    }

    return NULL;
}

int main() {
    pthread_t t0, t1;

    // Initialize semaphore with value 1 for mutual exclusion
    sem_init(&mutex, 0, 1);

    // Create two threads (representing two processes)
    pthread_create(&t0, NULL, process0, NULL);
    pthread_create(&t1, NULL, process1, NULL);

    // Join the threads (in this case, they run indefinitely)
    pthread_join(t0, NULL);
    pthread_join(t1, NULL);

    // Destroy the semaphore
    sem_destroy(&mutex);

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