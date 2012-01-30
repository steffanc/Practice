#include <iostream>
#include <string.h>
#include <math.h>

using namespace std;

void pIntBin(unsigned a) {
  char out[32];
  for (int i=0; i<32; ++i) {
    out[31-i] = ((1&(a>>i))==1?'1':'0');
  }
  cout << out << endl;
}

void pSmallLarge(unsigned a) {
  pIntBin(a);
  pIntBin((a-1)^a);
  unsigned large = ((a-1)^a)+1 | ((a-1)&a);
  pIntBin(large);
  unsigned small = (((a-1)^a)+1 >> 2) | ((a-1)&a);
  pIntBin(small);
}

int main() {
  pSmallLarge(8);
  return 0;
}
