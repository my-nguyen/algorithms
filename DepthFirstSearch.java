class DepthFirstSearch {
   public static void main(String[] args) {
      if (args.length != 0) {
         int size = Integer.parseInt(args[0]);

         MyArray array = new MyArray(size, false);
         array.generate();
         System.out.println(array);

         BinaryTree tree = new BinaryTree();
         for (int i = 0; i < array.array.length; i++)
            tree.insert(array.array[i]);
         System.out.println(tree.preOrderString());
         System.out.println(tree.inOrderString());
         System.out.println(tree.postOrderString());
      }
   }
}
