#include <iostream>
#include <string.h>

using namespace std;

void mergeArrays(int* a, int* b, int lenA, int lenB) {
  int posA = lenA-1, posB = lenB-1, posOut = (lenA+lenB)-1;
  while (posA >= 0 & posB >= 0)
    a[posOut--] = ((a[posA] > b[posB]) ? (a[posA--]) : (b[posB--]));
  while (posB >= 0)
    a[posOut--] = b[posB--];
}

void mergeArrays2(int* a, int* b, int lenA, int lenB) {
  int posA = lenA-1, posB = lenB-1, posOut = (lenA+lenB)-1;
  while (true) {
    cout << posA << ", " << posB << ", " << posOut << endl;
    if (posA == -1 & posB == -1) break;
    else if (posA == -1) a[posOut--] = b[posB--];
    else if (posB == -1) a[posOut--] = a[posA--];
    else if (a[posA] > b[posB]) a[posOut--] = a[posA--];
    else a[posOut--] = b[posB--];
  }
}

int main() {
  int lenA = 3, sizeA =6, lenB=3;
  int a[6];
  int b[3];
  a[0]=1;a[1]=3;a[2]=5;
  b[0]=2;b[1]=4;b[2]=6;
  mergeArrays2(a,b,lenA,lenB);
  for (unsigned i=0; i<sizeA; ++i)
    cout << a[i] << ", ";
  cout << endl;
  return 0;
}
