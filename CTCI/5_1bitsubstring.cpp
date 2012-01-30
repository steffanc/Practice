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

void bitSub(unsigned a, unsigned b, int i, int j) {
  unsigned mask = (unsigned(pow(2,(j-i)+1))-1) << i;
  unsigned clear = 0xFFFFFFFF ^ mask;
  pIntBin(a);
  pIntBin(b);
  pIntBin(mask);
  pIntBin(clear);
  a &= clear;
  pIntBin(a);
  a |= (b << i);
  pIntBin(a);
  cout << a << endl;
}

int main() {
  unsigned a = 1024;
  unsigned b = 21;
  int i=2,j=6;
  bitSub(a,b,i,j);
}
