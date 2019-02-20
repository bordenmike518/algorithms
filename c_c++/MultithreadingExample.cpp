#include <iostream>
#include <cstdlib>
#include <pthread.h>

using namespace std;

#define NUM_THREADS 2

void *multithreadingExample(void *threadId) {
    long tid = (long) threadId;
    for(int i = 0; i < 5; i++)
        cout << "Hello from thread " << tid << ":  " << i << endl;
    pthread_exit(NULL);
}

int main(int argc, char **argv) {
    pthread_t threads[NUM_THREADS];

    for(long i = 0; i < NUM_THREADS; i++) {
        int pt = pthread_create(&threads[i], NULL, multithreadingExample, (void *)i);
        if (pt) {
            cout << "Error: unable to create thread " << pt << endl;
            exit(-1); 
        }
    }
    pthread_exit(NULL);
    cout << "Closing" << endl;
}
