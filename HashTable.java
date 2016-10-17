import java.util.*;

class Hash {
   static final int MAX = 11;
   // hash table, with chaining (linked list) as collision resolution
   // the linked list is just a List<Integer>, but Java doesn't support
   // List<Integer>[] (array). so an alternative is
   // List<List<Integer>> table = new ArrayList<List<Integer>>();
   // but the outer List is awkward, because inserting a new entry doesn't base
   // on the integer index, and neither does iterating thru the list.
   // so a better choice is a Map<Integer, List<Integer>>
   Map<Integer, List<Integer>> table;

   Hash() {
      table = new HashMap<>();
   }

   void insert(int value) {
      int index = value % MAX;
      // System.out.println("value: " + value + ", index: " + index + ", table size: " + table.size());
      if (!table.containsKey(index))
         table.put(index, new ArrayList<>());

      List<Integer> bucket = table.get(index);
      if (bucket.indexOf(value) == -1)
         bucket.add(value);
   }

   boolean contains(int value) {
      int index = value % MAX;
      if (table.get(index) == null)
         return false;

      return table.get(index).contains(value);
   }

   public String toString() {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<Integer, List<Integer>> entry : table.entrySet()) {
         builder.append(entry.getKey()).append(": ");
         for (int value : entry.getValue())
            builder.append(value).append(" ");
         builder.append("\n");
      }
      return builder.toString();
   }
}

class HashTable {
   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         int[] array = MyArray.generate(size);
         System.out.println("generated: " + MyArray.toString(array));
         Hash hash = new Hash();
         for (int value : array)
            hash.insert(value);
         System.out.print(hash);
      }
   }
}
