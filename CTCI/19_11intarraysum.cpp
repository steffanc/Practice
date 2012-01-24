#include <iostream>
#include <string.h>
#include <map>

using namespace std;

void pairSum(int* in, int len, int tar) {
  map<int,bool> table;
  for (int i=0; i<len; ++i) {
    if (table[tar-in[i]]) {
      cout << in[i] << ", " << tar-in[i] << endl;
    } else {
      table[in[i]]=true;
    }
  }
}

void pairSum2(int* in, int len, int tar) {
  int l=0,u=len-1;
  while (l<u) {
    if (in[l]+in[u] == tar) {
      cout << in[l] << ", " << in[u] << endl;
      u--; l++;
    } else if (in[l]+in[u] > tar) {
      --u;
    } else {
      ++l;
    }
  }
}

int main() {
  int len = 6;
  //int in[] = {1,3,6,4,8,-1};
  int in[] = {-1,1,3,4,6,8};
  pairSum2(in,len,7);
  return 0;
}
