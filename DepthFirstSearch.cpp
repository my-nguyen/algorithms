#include <iostream>
#include "MyArray.h"
#include "BinaryTree.h"
using namespace std;

int main(int argc, char** argv) {
   if (argc != 1) {
      int size = stoi(argv[1]);

      MyArray array(size, false);
      array.generate();
      cout << array << endl;

      BinaryTree tree;
      for (int i = 0; i < size; i++)
         tree.insert(array.array[i]);
      cout << tree.preOrderString() << endl;
      cout << tree.inOrderString() << endl;
      cout << tree.postOrderString() << endl;
   }
}
