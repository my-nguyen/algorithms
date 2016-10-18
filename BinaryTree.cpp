#include <queue>
#include "BinaryTree.h"

Node* BinaryTree::search(int number) {
   Node* current = root;
   while (current != 0) {
      if (current->data == number)
         return current;
      else if (number < current->data)
         current = current->left;
      else
         current = current->right;
   }
   return 0;
}

void BinaryTree::insert(int data) {
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

string BinaryTree::preOrderString() {
   string output;
   preorder(output, root);
   return output;
}

string BinaryTree::inOrderString() {
   string output;
   inorder(output, root);
   return output;
}

string BinaryTree::postOrderString() {
   string output;
   postorder(output, root);
   return output;
}

string BinaryTree::breathFirst() {
   string output;
   if (root == 0)
      return output;

   queue<Node*> queue;
   queue.push(root);
   while (!queue.empty()) {
      Node* node = queue.front();
      queue.pop();
      output += to_string(node->data) + " ";
      if (node->left != 0)
         queue.push(node->left);
      if (node->right != 0)
         queue.push(node->right);
   }
   return output;
}

void BinaryTree::preorder(string& output, Node* current) {
   if (current == 0) {
      return;
   }

   output += to_string(current->data) + " ";
   preorder(output, current->left);
   preorder(output, current->right);
}

void BinaryTree::inorder(string& output, Node* current) {
   if (current == 0) {
      return;
   }

   inorder(output, current->left);
   output += to_string(current->data) + " ";
   inorder(output, current->right);
}

void BinaryTree::postorder(string& output, Node* current) {
   if (current == 0) {
      return;
   }

   postorder(output, current->left);
   postorder(output, current->right);
   output += to_string(current->data) + " ";
}
