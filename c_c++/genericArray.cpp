#include "genericArray.h"

Array::Array(int s) {
    size=s;
    elems=new T[size];
    for(int i=0;i<size;i++)
        elems[i]=0;
}

Array::~Array() {
    delete elems;
}

T& Array::operator[](int index) {
    return elems[index];
}

void Array::operator=(T temp) {
     for(int i=0;i<size;i++)
         elems[i]=temp;
}
