#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

sem_t rw_mutex, mutex;
int read_count = 0;
int shared_data = 0;

void *reader(void *arg) {
    int id = *((int *)arg);
    while (1) {
        sem_wait(&mutex);
        read_count++;
        if (read_count == 1)
            sem_wait(&rw_mutex);
        sem_post(&mutex);

        printf("Reader %d reads shared_data = %d\n", id, shared_data);
        sleep(1);

        sem_wait(&mutex);
        read_count--;
        if (read_count == 0)
            sem_post(&rw_mutex);
        sem_post(&mutex);

        sleep(rand() % 2);
    }
}

void *writer(void *arg) {
    int id = *((int *)arg);
    while (1) {
        sem_wait(&rw_mutex);

        shared_data = rand() % 100;
        printf("Writer %d writes shared_data = %d\n", id, shared_data);
        sleep(1);

        sem_post(&rw_mutex);

        sleep(rand() % 3);
    }
}

int main() {
    pthread_t readers[3], writers[2];
    int reader_ids[3], writer_ids[2];

    sem_init(&rw_mutex, 0, 1);
    sem_init(&mutex, 0, 1);

    for (int i = 0; i < 3; i++) {
        reader_ids[i] = i + 1;
        pthread_create(&readers[i], NULL, reader, &reader_ids[i]);
    }

    for (int i = 0; i < 2; i++) {
        writer_ids[i] = i + 1;
        pthread_create(&writers[i], NULL, writer, &writer_ids[i]);
    }

    for (int i = 0; i < 3; i++)
        pthread_join(readers[i], NULL);

    for (int i = 0; i < 2; i++)
        pthread_join(writers[i], NULL);

    sem_destroy(&rw_mutex);
    sem_destroy(&mutex);

    return 0;
}

/*
Sample Input/Output:

Reader 3 reads shared_data = 0
Reader 2 reads shared_data = 0
Reader 1 reads shared_data = 0
Writer 1 writes shared_data = 15
Writer 2 writes shared_data = 35
Reader 1 reads shared_data = 35
Reader 3 reads shared_data = 35
Reader 2 reads shared_data = 35
Writer 1 writes shared_data = 62
Writer 2 writes shared_data = 90
Reader 3 reads shared_data = 90
Reader 2 reads shared_data = 90
Reader 1 reads shared_data = 90
...
*/