#include <iostream>
#include "MyArray.h"
using namespace std;

void sort(int array[], int size) {
   // repeat the inner loop for (size-1) times
   for (int i = size; i > 0; i--) {
      for (int j = 0; j < i-1; j++) {
         // compare 2 adjacent elements and swap them if necessary to ensure
         // the left element is smaller than the right element
         if (array[j] > array[j+1]) {
            int tmp = array[j];
            array[j] = array[j+1];
            array[j+1] = tmp;
         }
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
