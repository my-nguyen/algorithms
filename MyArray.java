import java.util.*;

class MyArray {
   static int[] generate(int size) {
      final int MAX = 100;
      int[] array = new int[size];
      Random random = new Random();
      for (int i = 0; i < size; i++) {
         array[i] = random.nextInt(MAX);
      }
      return array;
   }

   static String toString(int[] array) {
      return toString(array, 0, array.length);
   }

   static String toString(int[] array, int low, int high) {
      StringBuilder builder = new StringBuilder();
      for (int i = low; i < high; i++) {
         builder.append(array[i]).append(" ");
      }
      return builder.toString();
   }
}
