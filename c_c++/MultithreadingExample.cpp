#include <iostream>
#include <pthread.h>

using namespace std;

#define NUM_THREADS 6

void *multithreadingExample(void *threadId);

int main(int argc, char **argv) {
    pthread_t threads[NUM_THREADS];
    pthread_attr_t attr;
    pthread_attr_init(&attr);
    int pt;

    for(long i = 0; i < NUM_THREADS; i++) {
        pt = pthread_create(&threads[i], &attr, multithreadingExample, (void *)i);
        if (pt) {
            cout << "Error: unable to create thread " << pt << endl;
            exit(-1); 
        }
    }

    for (int i = 0; i < NUM_THREADS; i++)
        pthread_join(threads[i], NULL);

    cout << "Closing" << endl;
}

void *multithreadingExample(void *threadId) {
    long tid = (long) threadId;
    string message;
    for(int i = 0; i < 10; i++) {
        message = "Hello from thread " + to_string(tid) + ":  " + to_string(i) + "\n";
        cout << message;
        /* Multithreading print out issue example */
        //cout << "Hello from thread " << tid << ":  " << i << endl;
    }
    pthread_exit(NULL);
}
