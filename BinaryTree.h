#include <iostream>
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

class BinaryTree {
public:
   Node* root;

   BinaryTree() {
      root = 0;
   }

   Node* search(int number);

   void insert(int data);

   string preOrderString();

   string inOrderString();

   string postOrderString();

   string breathFirst();

private:
   void preorder(string& output, Node* current);

   void inorder(string& output, Node* current);

   void postorder(string& output, Node* current);
};
