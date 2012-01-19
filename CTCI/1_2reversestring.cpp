#include <iostream>
#include <map>
#include <string.h>

using namespace std;

void strrev(char* str) {
	unsigned len = strlen(str);
	char* p1=str;
	char* p2 = (str+len)-1;
	char tmp;

	while (p1<p2) {
		tmp=*p1;
		*p1++=*p2;
		*p2--=tmp;
	}
}

int main() {
	char str[] = "abcdefg";
	cout << str << endl;
	strrev(str);

	cout << str << endl;
}
