#include <iostream>
#include <string.h>

using namespace std;

int numBits(int n) {
  int count=0;
  while (n!=0) {
    count++;
    n = n&(n-1);
  }
  return count;
}

int main() {
  cout << numBits(16) << endl;
  return 0;
}
