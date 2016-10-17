class MergeSort {
   static void sort(int[] array, int low, int high) {
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
      int[] leftpartition = new int[middle-low+1];
      for (int i = low; i <= middle; i++)
         leftpartition[i-low] = array[i];
      // make a copy of the right partition
      int[] rightpartition = new int[high-middle];
      for (int i = middle+1; i <= high; i++)
         rightpartition[i-middle-1] = array[i];

      // index to leftpartition
      int i = 0;
      // index to rightpartition
      int j = 0;
      // index to array
      int k = low;
      while (i < leftpartition.length && j < rightpartition.length) {
         if (leftpartition[i] <= rightpartition[j]) {
            // copy to array those in leftpartition that are smaller than those
            // in rightpartition
            array[k] = leftpartition[i];
            i++;
         } else {
            // copy to array those in rightpartition that are smaller than those
            // in leftpartition
            array[k] = rightpartition[j];
            j++;
         }
         k++;
      }

      // copy any remaining uncopied elements in leftpartition and rightpartition
      while (i < leftpartition.length) {
         array[k] = leftpartition[i];
         i++;
         k++;
      }
      while (j < rightpartition.length) {
         array[k] = rightpartition[j];
         j++;
         k++;
      }
   }

   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         MyArray array = new MyArray(size);
         array.generate();
         System.out.println("generated: " + array);
         sort(array.array, 0, size-1);
         System.out.println("sorted:    " + array);
      }
   }
}
