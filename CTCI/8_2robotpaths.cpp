#include <iostream>
#include <string.h>

using namespace std;

void gridpaths(unsigned &ans, unsigned n, unsigned x, unsigned y) {
	if (x == n & y == n) {
		ans++;
		return;
	}
	if (x!=n) gridpaths(ans,n,x+1,y);
	if (y!=n) gridpaths(ans,n,x,y+1);
}

int main() {
	unsigned num=0;
	gridpaths(num,9,1,1);
	cout << num << endl;
}
