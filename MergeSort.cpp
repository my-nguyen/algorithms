#include <iostream>
#include "MyArray.h"
using namespace std;

void sort(int array[], int low, int high) {
   // the base case to quit recursive calls
   if (high-low < 1)
      return;

   // find a mid-point
   int middle = low + (high-low)/2;
   // recursively sort the array partition to the LEFT of the mid-point
   sort(array, low, middle);
   // recursively sort the array partition to the RIGHT of the mid-point
   sort(array, middle+1, high);

   /// remaining is the bulk of the work: to merge 2 sorted subarrays
   // make a copy of the left partition
   int leftSize = middle-low+1;
   int* leftPartition = new int[leftSize];
   for (int i = low; i <= middle; i++)
      leftPartition[i-low] = array[i];
   // make a copy of the right partition
   int rightSize = high-middle;
   int* rightPartition = new int[rightSize];
   for (int i = middle+1; i <= high; i++)
      rightPartition[i-middle-1] = array[i];

   // index to leftPartition
   int i = 0;
   // index to rightPartition
   int j = 0;
   // index to array
   int k = low;
   while (i < leftSize && j < rightSize) {
      if (leftPartition[i] <= rightPartition[j]) {
         // copy to array those in leftPartition that are smaller than those
         // in rightPartition
         array[k] = leftPartition[i];
         i++;
      } else {
         // copy to array those in rightPartition that are smaller than those
         // in leftPartition
         array[k] = rightPartition[j];
         j++;
      }
      k++;
   }

   // copy any remaining uncopied elements in leftPartition and rightPartition
   while (i < leftSize) {
      array[k] = leftPartition[i];
      i++;
      k++;
   }
   while (j < rightSize) {
      array[k] = rightPartition[j];
      j++;
      k++;
   }

   delete [] rightPartition;
   delete [] leftPartition;
}

int main(int argc, char** argv) {
   if (argc != 0) {
      int size = stoi(argv[1]);
      MyArray array(size);
      array.generate();
      cout << "generated: " << array << endl;
      sort(array.array, 0, size-1);
      cout << "sorted:    " << array << endl;
   }
}
