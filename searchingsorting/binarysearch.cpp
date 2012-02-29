#include <iostream>
#include <string.h>

using namespace std;

int bSearch(int* a, int len, const int tar) {
  int l=0, u=len-1, pos=0;
  while (l<=u) {
    pos = (l+u)/2;
    if (tar == a[pos]) return tar;
    else if (a[pos] < tar)
      l=pos+1;
    else if (a[pos] > tar)
      u=pos-1;
  }
  return -1;
}

int recBSearch(int* a, int len, int tar, int u, int l) {
  if (l>u) return -1;
  int pos = (l+u)/2;
  if (tar == a[pos]) return tar;
  else {
    if (a[pos] < tar) return recBSearch(a,len,tar,u,pos+1);
    if (a[pos] > tar) return recBSearch(a,len,tar,pos-1,l);
  }
}

int main() {
  int len=12, tar=26;
  int nums[] = {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25};
  cout << bSearch(nums,len,tar) << endl;
  cout << recBSearch(nums,len,tar,len-1,0) << endl;
  return 0;
}
