import java.util.*;

class MyArray {
   static final int MAX = 100;
   int[] array;
   boolean duplicate;

   MyArray(int size) {
      this(size, true);
   }

   MyArray(int size, boolean duplicate) {
      this.array = new int[size];
      this.duplicate = duplicate;
   }

   void generate() {
      Random random = new Random();
      if (duplicate) {
         for (int i = 0; i < array.length; i++) {
            int number = random.nextInt(MAX);
            array[i] = number;
         }
      } else {
         // no duplicate allowed!
         Set<Integer> set = new HashSet<>();
         // generate numbers into a set, to avoid duplicates
         while (set.size() != array.length) {
            int number = random.nextInt(MAX);
            set.add(number);
         }
         // transfer the set contents to the data array
         Iterator<Integer> it = set.iterator();
         int i = 0;
         while (it.hasNext()) {
            array[i] = it.next();
            i++;
         }
      }
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
