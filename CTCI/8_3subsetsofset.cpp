#include <iostream>
#include <string.h>

using namespace std;

void subsets(char* set, char* out, unsigned len, unsigned pos, unsigned lev) {
	for (int i=pos; i<len; ++i) {
		out[lev] = set[i];
		out[lev+1] = '\0';
		cout << out << endl;
		subsets(set,out,len,i+1,lev+1);
	}
}

int main() {
	char set[] = "abc";
	unsigned len = strlen(set);
	char out[len];
	subsets(set,out,len,0,0);
}
