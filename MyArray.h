#include <iostream>
using namespace std;

#define MAX 100;

class MyArray {
public:
   int* array;
   int size;
   bool duplicate;

   MyArray(int size, bool duplicate=true);

   ~MyArray() {
      delete [] array;
   }

   void generate();

   friend ostream& operator<<(ostream& stream, MyArray& array);
};
