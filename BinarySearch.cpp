#include <iostream>
#include "MyArray.h"
using namespace std;

// perform binary search
int search(int list[], int size, int target) {
   int lower = 0;
   int upper = size;
   while (true) {
      if (upper < lower)
         return -1;

      int middle = lower + (upper-lower)/2;
      if (list[middle] < target) {
         lower = middle + 1;
      } else if (list[middle] > target) {
         upper = middle - 1;
      } else {
         return middle;
      }
   }
}

int compare(const void* left, const void* right) {
   return *(int*)left - *(int*)right;
}

int main(int argc, char** argv) {
   if (argc > 1) {
      int size = stoi(argv[1]);
      MyArray array(size);
      array.generate();
      cout << array << endl;
      qsort(array.array, size, sizeof(int), compare);
      cout << array << endl;
      srand(time(NULL));
      int index = argc == 3 ? stoi(argv[2]) : (rand() % size);
      int target = array.array[index];
      cout << "target: " << target << endl;
      cout << search(array.array, size, target) << endl;
   }
   return 0;
}
