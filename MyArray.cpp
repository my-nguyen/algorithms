#include <cstdlib>
#include <unordered_set>
#include "MyArray.h"

#define MAX 100;

MyArray::MyArray(int size, bool duplicate) {
   this->array = new int[size];
   this->size = size;
   this->duplicate = duplicate;
}

void MyArray::generate() {
   srand(time(NULL));
   if (duplicate) {
      for (int i = 0; i < size; i++) {
         int number = rand() % MAX;
         array[i] = number;
      }
   } else {
      // no duplicate allowed!
      // note the use of unordered_set and not set, because set sorts its contents
      unordered_set<int> tmp;
      // generate numbers into a set, to avoid duplicates
      while (tmp.size() != size) {
         int number = rand() % MAX;
         tmp.insert(number);
      }
      // transfer the set contents to the data array
      int i = 0;
      for (unordered_set<int>::iterator it = tmp.begin(); it != tmp.end(); it++) {
         array[i] = *it;
         i++;
      }
   }
}

ostream& operator<<(ostream& stream, MyArray& array) {
   for (int i = 0; i < array.size; i++)
      stream << array.array[i] << " ";
   return stream;
}
