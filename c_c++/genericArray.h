template<class T>
class Array {
  private:
    T *elems;
    int size;
  public:
    Array(int s);
    ~Array();
    T& operator[](int index);
    void operator=(T temp);
};
