class BubbleSort {
   static void sort(int[] array, int size) {
      // repeat the inner loop for (size-1) times
      for (int i = size; i > 0; i--) {
         for (int j = 0; j < i-1; j++) {
            // compare 2 adjacent elements and swap them if necessary to ensure
            // the left element is smaller than the right element. At the end of
            // each pass, the largest value of that pass is moved to its proper place
            if (array[j] > array[j+1]) {
               int tmp = array[j];
               array[j] = array[j+1];
               array[j+1] = tmp;
            }
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
