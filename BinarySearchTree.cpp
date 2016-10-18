#include <iostream>
#include "MyArray.h"
using namespace std;

class Node {
public:
   int data;
   Node* left;
   Node* right;

   Node(int number) {
      data = number;
      left = 0;
      right = 0;
   }
};

class Tree {
public:
   Node* root;

   Tree() {
      root = 0;
   }

   Node* search(int number) {
      Node* current = root;
      while (current->data != number) {
         if (current->data > number)
            current = current->left;
         else
            current = current->right;

         if (current == 0)
            return 0;
      }
      return current;
   }

   void insert(int data) {
      Node* node = new Node(data);
      if (root == 0) {
         // cout << "inserting " << data << " as root" << endl;
         root = node;
         return;
      }

      Node* current = root;
      while (true) {
         if (current->data > data) {
            if (current->left == 0) {
               // cout << "inserting " << data << " to LEFT of " << current->data << endl;
               current->left = node;
               break;
            }
            else
               current = current->left;
         }
         else {
            if (current->right == 0) {
               // cout << "inserting " << data << " to RIGHT of " << current->data << endl;
               current->right = node;
               break;
            }
            else
               current = current->right;
         }
      }
   }

   friend ostream& operator<<(ostream& stream, Tree& tree) {
      // preorder(builder, root);
      tree.inorder(stream, tree.root);
      // postorder(builder, root);
      return stream;
   }

/*
   void preorder(StringBuilder builder, Node current) {
      if (current == null) {
         return;
      }

      // System.out.println("current: " + current->data);
      builder.append(current->data).append(" ");
      preorder(builder, current->left);
      preorder(builder, current->right);
   }
*/

   void inorder(ostream& stream, Node* current) {
      if (current == 0) {
         return;
      }

      inorder(stream, current->left);
      stream << current->data << " ";
      // builder.append(current->data).append(" ");
      inorder(stream, current->right);
   }

/*
   void postorder(StringBuilder builder, Node current) {
      if (current == null) {
         return;
      }

      postorder(builder, current->left);
      postorder(builder, current->right);
      // System.out.println("current: " + current->data);
      builder.append(current->data).append(" ");
   }
*/
};

int main(int argc, char** argv) {
   if (argc != 1) {
      int size = stoi(argv[1]);
      Tree tree;
      /*
      int numbers[] = { 8, 3, 9, 1, 5, 4, 12, 11 };
      for (int i = 0; i < sizeof(numbers)/sizeof(int); i++)
         tree.insert(numbers[i]);
         */
      MyArray array(size, false);
      array.generate();
      cout << array << endl;
      for (int i = 0; i < size; i++)
         tree.insert(array.array[i]);
      cout << tree << endl;
   }
}
