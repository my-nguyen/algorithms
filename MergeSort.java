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
      int[] leftPartition = new int[middle-low+1];
      for (int i = low; i <= middle; i++)
         leftPartition[i-low] = array[i];
      // make a copy of the right partition
      int[] rightPartition = new int[high-middle];
      for (int i = middle+1; i <= high; i++)
         rightPartition[i-middle-1] = array[i];

      // index to leftPartition
      int i = 0;
      // index to rightPartition
      int j = 0;
      // index to array
      int k = low;
      while (i < leftPartition.length && j < rightPartition.length) {
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
      while (i < leftPartition.length) {
         array[k] = leftPartition[i];
         i++;
         k++;
      }
      while (j < rightPartition.length) {
         array[k] = rightPartition[j];
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
