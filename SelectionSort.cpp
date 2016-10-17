#include <iostream>
#include "MyArray.h"
using namespace std;

void sort(int array[], int size) {
   // process the leftmost element from left to right
   for (int sorted = 0; sorted < size-1; sorted++) {
      int min = sorted;
      // look for element with value less than the leftmost element (array[sorted])
      for (int i = sorted+1; i < size; i++) {
         if (array[i] < array[min])
            min = i;
      }
      // if such an element is found, swap it with the leftmost element
      if (min != sorted) {
         int tmp = array[sorted];
         array[sorted] = array[min];
         array[min] = tmp;
      }
   }
}

int main(int argc, char** argv) {
   if (argc != 1) {
      int size = stoi(argv[1]);
      MyArray array(size);
      array.generate();
      cout << "generated: " << array << endl;
      sort(array.array, size);
      cout << "sorted:    " << array << endl;
   }
}
