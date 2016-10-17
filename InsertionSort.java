class InsertionSort {
   static void sort(int[] array, int size) {
      // processing starts from element at index 1; the subarray of one element
      // at index 0 is sorted.
      for (int i = 1; i < size; i++) {
         int j = 0;
         // look in the subarray to the left for a possible spot to insert
         // the current element to render the subarray sorted
         while (j < i && array[j] <= array[i]) {
            j++;
         }

         // the insertion spot is found
         if (j < i) {
            int tmp = array[i];
            // shift the whole subarray, one element to the right, starting from
            // the insertion spot
            for (int k = i; k > j; k--) {
               array[k] = array[k-1];
            }
            // insert the current element at the insertion spot
            array[j] = tmp;
         }
      }
   }

   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         MyArray array = new MyArray(size);
         array.generate();
         System.out.println("generated: " + array);
         sort(array.array, size);
         System.out.println("sorted:    " + array);
      }
   }
}
