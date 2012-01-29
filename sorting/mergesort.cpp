#include <iostream>
#include <string.h>

using namespace std;

int _l = 7;

void pArray(int* a, int l) {
	for (int i=0; i<l; ++i) {
		cout << a[i];
	}
	cout << endl;
}

void merge(int* a, int l, int u) {
	int tempLen = (u-l)+1;
	int temp[tempLen];
	int mid = (l+u)/2; // takes the floor of the result
	int i=0, j=l, k=mid+1;
	while ((j<=mid) & (k<=u))
		temp[i++] = (a[j]<a[k]?a[j++]:a[k++]);

	while (j<=mid)
		temp[i++] = a[j++];

	while (k<=u)
		temp[i++] = a[k++];

	for (i=0; i<tempLen; ++i)
		a[l+i]=temp[i];
}

void mergeSort(int* a, int l, int u) {
	if (l>=u) return;
	int mid = (l+u)/2;
	cout << "low: " << l << ", up: " << u << ", mid: " << mid << endl;
	mergeSort(a,l,mid);
	mergeSort(a,mid+1,u);
	merge(a,l,u);
	pArray(a,_l);
}

int main() {
	int a[] = {7,6,5,4,3,2,1};
	pArray(a,_l);
	mergeSort(a,0,_l-1);
	pArray(a,_l);
	return 0;
}
