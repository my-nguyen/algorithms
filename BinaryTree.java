import java.util.*;

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

class BinaryTree {
   Node root;

   BinaryTree() {
      root = null;
   }

   Node search(int number) {
      Node current = root;
      while (current != null) {
         if (current.data == number)
            return current;
         else if (number < current.data)
            current = current.left;
         else
            current = current.right;
      }
      return null;
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

   String preOrderString() {
      StringBuilder builder = new StringBuilder();
      preorder(builder, root);
      return builder.toString();
   }

   String inOrderString() {
      StringBuilder builder = new StringBuilder();
      inorder(builder, root);
      return builder.toString();
   }

   String postOrderString() {
      StringBuilder builder = new StringBuilder();
      postorder(builder, root);
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

   String breathFirst() {
      StringBuilder builder = new StringBuilder();
      if (root == null)
         return builder.toString();

      Deque<Node> queue = new LinkedList<>();
      queue.clear();
      queue.add(root);
      while (!queue.isEmpty()) {
         Node node = queue.remove();
         builder.append(node.data).append(" ");
         if (node.left != null)
            queue.add(node.left);
         if (node.right != null)
            queue.add(node.right);
      }
      return builder.toString();
   }
}
