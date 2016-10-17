import java.util.*;

class BinarySearch {

   // perform binary search
   static int search(int[] list, int target) {
      int lower = 0;
      int upper = list.length;
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

   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         MyArray array = new MyArray(size);
         array.generate();
         System.out.println(array);
         Arrays.sort(array.array);
         System.out.println(array);
         int index = new Random().nextInt(size);
         int target = array.array[index];
         System.out.println("target: " + target);
         System.out.println(search(array.array, target));
      }
   }
}
