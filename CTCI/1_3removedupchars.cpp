#include <iostream>
#include <string.h>

using namespace std;

void removeDup(char* str) {
	unsigned len = strlen(str);

	for (unsigned i=0; i<len-1; ++i) {
		unsigned numDups =0;
		for (unsigned j=i+1; j<len; ++j) {
			if (str[i]==str[j])
				++numDups;
			else if (numDups!=0)
				str[j-numDups] = str[j];
		}
		len -= numDups;
	}
	str[len]='\0';
}

int main() {
	char str[] = "aabbcacbdddefegefhfgg";
	cout << str << endl;
	removeDup(str);
	cout << str << endl;
}
