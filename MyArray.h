#include <cstdlib>
#include <iostream>
using namespace std;

#define MAX 100;

class MyArray {
public:
   int* array;
   int size;

   MyArray(int size) {
      this->array = new int[size];
      this->size = size;
   }

   ~MyArray() {
      delete [] array;
   }

   void generate() {
      srand(time(NULL));
      for (int i = 0; i < size; i++)
         array[i] = rand() % MAX;
   }

   friend ostream& operator<<(ostream& stream, MyArray& array) {
      for (int i = 0; i < array.size; i++)
         stream << array.array[i] << " ";
      return stream;
   }
};
