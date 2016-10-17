import java.util.*;

class MyArray {
   static final int MAX = 100;
   int[] array;

   MyArray(int size) {
      this.array = new int[size];
   }

   void generate() {
      Random random = new Random();
      for (int i = 0; i < array.length; i++)
         array[i] = random.nextInt(MAX);
   }

   public String toString() {
      return toString(array, 0, array.length);
   }

   String toString(int[] array, int low, int high) {
      StringBuilder builder = new StringBuilder();
      for (int i = low; i < high; i++) {
         builder.append(array[i]).append(" ");
      }
      return builder.toString();
   }
}
