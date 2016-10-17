// g++ HashTable.cpp -std=c++11
#include <cstring>
#include <iostream>

using namespace std;

#define MAX 5

struct Data {
   int key;
   char *value;
   struct Data *next;

   Data(int key, const char* value) {
      this->key = key;
      this->value = new char[strlen(value)+1];
      strcpy(this->value, value);
      this->next = 0;
   }

   ~Data() {
      delete [] value;
   }

   friend ostream& operator<<(ostream& stream, const Data& data) {
      stream << "{" << data.key << ", " << data.value << "}";
      return stream;
   }
};

class Hash {
public:
   static int hash(int key) {
      return key % MAX;
   }

   Hash() {
      for (int i = 0; i < MAX; i++)
         table[i] = 0;
   }

   ~Hash() {
      for (int i = 0; i < MAX; i++) {
         if (table[i] != 0) {
            Data* current = table[i];
            Data* next = current->next;
            while (next != 0) {
               delete current;
               current = next;
               next = current->next;
            }
            delete current;
         }
      }
   }

   void insert(int key, const char* value) {
      int index = hash(key);
      Data* data = new Data(key, value);
      if (table[index] == 0)
         // current slot empty: create a new linked list with data as first Node
         table[index] = data;
      else {
         // current slot not empty: traverse to the end of the linked list before
         // inserting Data as last Node
         Data* current = table[index];
         while (current->next != 0)
            current = current->next;
         current->next = data;
      }
   }

   Data* find(int key) {
      int index = hash(key);
      // if key is not found, return null
      if (table[index] == 0)
         return 0;

      // if key is found, traverse the linked list to find and return Data
      for (Data* current = table[index]; current != 0; current = current->next) {
         if (current->key == key)
            return current;
      }
      return 0;
   }

   friend ostream& operator<<(ostream& stream, const Hash& hash) {
      for (int i = 0; i < MAX; i++) {
         stream << i << ": ";
         if (hash.table[i] == 0)
            stream << "null";
         else {
            stream << *hash.table[i];
            for (Data* current = hash.table[i]->next; current != 0; current = current->next)
               stream << ", " << *current;
         }
         stream << "\n";
      }
      return stream;
   }

private:
   Data* table[MAX];
};

int main(int argc, char** argv) {
   Hash hash;
   hash.insert(0, "Zero");
   hash.insert(2, "Two");
   hash.insert(3, "Three");
   hash.insert(4, "Four");
   hash.insert(5, "Five");
   hash.insert(7, "Seven");
   hash.insert(8, "Eight");
   hash.insert(12, "Twelve");
   cout << hash;

   int cases[] = { 5, 3, 11 };
   for (int i = 0; i < sizeof(cases)/sizeof(int); i++) {
      Data* data = hash.find(cases[i]);
      if (data == 0)
         cout << cases[i] << ": null" << endl;
      else
         cout << *data << endl;
   }

   return 0;
}
