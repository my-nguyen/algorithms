import java.util.*;

class Data {
   int key;
   String value;
   Data next;

   Data(int key, String value) {
      this.key = key;
      this.value = value;
      this.next = null;
   }

   public String toString() {
      return "{" + key + ", " + value + "}";
   }
}

class Hash {
   static final int MAX = 5;
   // hash table, with chaining (linked list) as collision resolution
   // the linked list is just a List<Data>, but Java doesn't support
   // List<Data>[] (array). so an alternative is List<List<Data>>
   // but the outer List is awkward, because inserting a new entry doesn't base
   // on the integer index, and neither does iterating thru the list.
   // so a better choice is a Map<Integer, List<Data>>
   Map<Integer, List<Data>> table;

   Hash() {
      table = new HashMap<>();
   }

   static int hash(int key) {
      return key % MAX;
   }

   void insert(int key, String value) {
      int index = hash(key);
      if (!table.containsKey(index))
         // current slot empty: create a new linked list with data as first Node
         table.put(index, new ArrayList<>());

      // add Data into linked list as last Node
      List<Data> list = table.get(index);
      Data data = new Data(key, value);
      list.add(data);
   }

   Data find(int key) {
      int index = hash(key);
      // if key is not found, return null
      if (table.get(index) == null)
         return null;

      // if key is found, traverse the linked list to find and return Data
      for (Data current : table.get(index)) {
         if (current.key == key)
            return current;
      }
      return null;
   }

   public String toString() {
      StringBuilder builder = new StringBuilder();
      for (Map.Entry<Integer, List<Data>> entry : table.entrySet()) {
         builder.append(entry.getKey()).append(": ");
         for (Data value : entry.getValue())
            builder.append(value).append(", ");
         builder.append("\n");
      }
      return builder.toString();
   }
}

class HashTable {
   public static void main(String[] args) {
      /*
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         int[] array = MyArray.generate(size);
         System.out.println("generated: " + MyArray.toString(array));
         Hash hash = new Hash();
         for (int value : array)
            hash.insert(value);
         System.out.print(hash);
      }
      */
      Hash hash = new Hash();
      hash.insert(0, "Zero");
      hash.insert(2, "Two");
      hash.insert(3, "Three");
      hash.insert(4, "Four");
      hash.insert(5, "Five");
      hash.insert(7, "Seven");
      hash.insert(8, "Eight");
      hash.insert(12, "Twelve");
      System.out.print(hash);

      int[] cases = { 5, 3, 11 };
      for (int i = 0; i < cases.length; i++) {
         Data data = hash.find(cases[i]);
         if (data == null)
            System.out.println(cases[i] + ": null");
         else
            System.out.println(data);
      }
   }
}
