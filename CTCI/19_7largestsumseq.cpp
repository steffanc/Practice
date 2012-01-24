#include <iostream>
#include <string.h>

using namespace std;

void largestSum(int* in, int len) {
  int sum=0,s=0,e=0;
  int bsum=0,bs=0,be=0;
  for (int i=0; i<len; ++i) {
    e=i;
    sum += in[i];
    if (i==0 || sum>bsum) {
      bsum=sum;
      bs=s;
      be=e;
    }
    if (sum<=0) {
      s=i+1;
      sum=0;
    }
  }

  cout << "Sum: " << bsum << endl;
  for (int i=bs; i<=be; ++i) {
    cout << in[i] << endl;
  }
}

int main(void) {
  int len = 4;
  //int in[] = {2,-8,3,-2,4,-10};
  int in[] = {-8,-2,-3,-4};
  largestSum(in,len);
  return 0;
}
