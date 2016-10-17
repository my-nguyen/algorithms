class SelectionSort {
   static void sort(int[] array, int size) {
      // move leftmost element from left to right
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
