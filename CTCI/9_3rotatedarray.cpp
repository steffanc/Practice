#include <iostream>
#include <string.h>
#include <math.h>

using namespace std;

int rotateSearch(int* nums, int len, int target) {
  int l=nums[0],r=nums[len-1];
  int pos = len/2, next=0, jump=2;
  while () {
    if (nums[pos]== target) return target;
    else if ((nums[pos] < target && target < l) ||
      (num[pos] > target && target < l)) {
      next = pos+(len/pow(2,jump));
    } else if ((num[pos] < target && num[pos] < l) ||
      num[pos] > target && num[pos] > l)
      next = pos-(len/pow(2,jump));
    }
  }
}

int main() {
  int len = 12, target = 5;
  int nums[] = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14}
  cout << rotateSearch(nums,len, target) << endl;
  return 0;
}
