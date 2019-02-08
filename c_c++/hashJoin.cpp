#include <stdio.h>
#include <typle>

using namespace std;

int main(int argc, char **argv) {


    return 0;
}

template <class T>
void hashJoin(T[] A, int Ajoincol, T[] B, int Bjoincol) {
    int hashkey;
    int Asize = sizeof(A);
    int Bsize = sizeof(B);
    int buff;
    tuple Ctuple;
    if (Asize > Bsize) {
        buff = Asize;
        Bsize = Asize;
        Asize = buff; 
    }
    tuple[] out = new tuple[Asize];
    auto Ahash = new tuple[Asize]; 
    for(int i = 0; i < Asize; i++) {
        hashkey = hash(get<Ajoincol>(A[i])) % Asize;
        Ahash[hashkey] = A[i];
    } 
    for(int j = 0; j < Bsize; j++) {
        hashkey = hash(get<Bjoincol>(B[j])) % Bsize;
        Ctuple = Ahash[hashkey];
        if (get<Ajoincol>(Ctuple) == get<Bjoincol>(B[j]))
            
    }    
}
