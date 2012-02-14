#include <iostream>
#include <string.h>

using namespace std;

// PROS
//  - can be done in place with O(1) space complexity
//  - runs in O(nlogn) with good choice of pivots
// CONS
//  - poor choice of pivot results in O(n^2) time complexity
//    - only choice of median results in O(nlogn)
//    - choice of median is an O(n) operation in itself
//    - good practice is to choose middle positioned element as pivot
//      - this is because sub lists tend to form as the algorithm runs and thus
//      you have a better chance of choosing the median value

int _l = 4;

void pArray(int* a, int l) {
	for (int i=0; i<l; ++i) {
		cout << a[i];
	}
	cout << endl;
}

void quickSort(int* a, int l, int u) {
  if (l>=u) return;
  int mid = (l+u)/2;
  int val = a[mid];
  int i=l,j=u;
  cout << "l: " << l << ", u: " << u << ", mid: " << mid << endl;

  // goal is to get i to index array where l to i is all elements < val
  // get j to index of array where j to u is all elements >= val
  // mid is always floor of division so this enforces elements >= val to be on
  // the right side of the array
  while (i <= j) {
    while (a[i] < val) {
      ++i;
    }
    while (a[j] > val) {
      --j;
    }
    if (i<=j) {
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
      ++i;
      --j;
    }
  }

  pArray(a,_l);
  if (l < j)
    quickSort(a,l,j);
  if (i < u)
    quickSort(a,i,u);
}

int main() {
	//int a[] = {3,6,1,4,2,4,7};
  int a[] = {2,4,1,3};
	pArray(a,_l);
  quickSort(a,0,_l-1);
	pArray(a,_l);
	return 0;
}
