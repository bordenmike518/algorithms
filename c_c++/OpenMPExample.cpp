#include <iostream>
#include <omp.h>

using namespace std;

#define N 100

int main(int argc, char **argv) {

    int *a, *b;
    a = (int*)malloc(N*sizeof(a));
    b = (int*)malloc(N*sizeof(b));
    
    for (int i = 0; i < N; i++) {
        a[i] = i;
        b[i] = i*i;
    }
    
    #pragma omp parallel for
    for (int i = 0; i < N; i++) 
        a[i] += b[i];

    for (int i = 0; i < N; i++)
        cout << a[i] << endl;

    return 1;
}
