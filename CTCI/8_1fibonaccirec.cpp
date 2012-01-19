#include <iostream>
#include <string.h>

using namespace std;

unsigned fibonacci(unsigned n1, unsigned n2, unsigned nc, unsigned n) {
	if (n==nc) return n1;
	else return fibonacci(n2,n1+n2,++nc,n);
}

int main() {
	unsigned num = fibonacci(0,1,1,9);
	cout << num << endl;
}
