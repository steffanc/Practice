#include <iostream>
#include <string.h>

using namespace std;

void swap(int& a, int& b) {
	cout << "a: " << a << ", b: "  << b << endl;
	a = a^b;
	b = a^b;
	a = a^b;
	cout << "a: " << a << ", b: "  << b << endl;
}

int main() {
	int a=1, b=2;
	swap(a,b);
	a=0;
	swap(a,b);
}
