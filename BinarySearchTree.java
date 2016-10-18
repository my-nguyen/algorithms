class Node {
   int data;
   Node left;
   Node right;

   Node(int number) {
      data = number;
      left = null;
      right = null;
   }
}

class Tree {
   Node root;

   Tree() {
      root = null;
   }

   Node search(int number) {
      Node current = root;
      while (current.data != number) {
         if (current.data > number)
            current = current.left;
         else
            current = current.right;

         if (current == null)
            return null;
      }
      return current;
   }

   void insert(int data) {
      Node node = new Node(data);
      if (root == null) {
         // System.out.println("inserting " + data + " as root");
         root = node;
         return;
      }

      Node current = root;
      while (true) {
         if (current.data > data) {
            if (current.left == null) {
               // System.out.println("inserting " + data + " to left of " + current.data);
               current.left = node;
               break;
            }
            else
               current = current.left;
         }
         else {
            if (current.right == null) {
               // System.out.println("inserting " + data + " to right of " + current.data);
               current.right = node;
               break;
            }
            else
               current = current.right;
         }
      }
   }

   public String toString() {
      StringBuilder builder = new StringBuilder();
      // preorder(builder, root);
      inorder(builder, root);
      // postorder(builder, root);
      return builder.toString();
   }

   void preorder(StringBuilder builder, Node current) {
      if (current == null) {
         return;
      }

      // System.out.println("current: " + current.data);
      builder.append(current.data).append(" ");
      preorder(builder, current.left);
      preorder(builder, current.right);
   }

   void inorder(StringBuilder builder, Node current) {
      if (current == null) {
         return;
      }

      inorder(builder, current.left);
      // System.out.println("current: " + current.data);
      builder.append(current.data).append(" ");
      inorder(builder, current.right);
   }

   void postorder(StringBuilder builder, Node current) {
      if (current == null) {
         return;
      }

      postorder(builder, current.left);
      postorder(builder, current.right);
      // System.out.println("current: " + current.data);
      builder.append(current.data).append(" ");
   }
}

class BinarySearchTree {
   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);
         Tree tree = new Tree();
         /*
         int[] numbers = { 8, 3, 9, 1, 5, 4, 12, 11 };
         for (int i = 0; i < numbers.length; i++)
            tree.insert(numbers[i]);
            */
         MyArray array = new MyArray(size, false);
         array.generate();
         System.out.println(array);
         for (int i = 0; i < array.array.length; i++)
            tree.insert(array.array[i]);
         System.out.println(tree);
      }
   }
}
