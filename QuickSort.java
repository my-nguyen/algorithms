class QuickSort {
   static void sort(int[] array, int low, int high) {
      // base case to quit recursive call
      if (high-low < 1)
         return;

      // the last index as pivot
      int pivot = high;
      // the first index as left
      int left = low;
      // the next-to-last index as right
      int right = high-1;

      while (true) {
         // while value at left is less than that at pivot, move right
         while (left < right && array[left] <= array[pivot])
         // while (array[left] < array[pivot])
            left += 1;
         // while value at right is greater than pivot, move left
         while (right > left && array[right] > array[pivot])
         // while (array[right] > array[pivot])
            right -= 1;
         // at this point, array[left] > array[pivot] > array[right], so swap
         // value at left and right
         if (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
         } else
            break;
      }

      // if value at right is greater than value at pivot, swap array[right] and
      // array[pivot]; also swap pivot
      if (array[right] > array[pivot]) {
         int tmp = array[right];
         array[right] = array[pivot];
         array[pivot] = tmp;

         pivot = right;
      }

      // partition the array into 2 and recursively sort those 2 partitions
      if (pivot > low) {
         sort(array, low, pivot-1);
      }
      if (pivot < high) {
         sort(array, pivot+1, high);
      }
   }

   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         int[] array = MyArray.generate(size);
         System.out.println("generated: " + MyArray.toString(array));
         sort(array, 0, array.length-1);
         System.out.println("sorted:    " + MyArray.toString(array));
      }
   }
}
