#include <iostream>
#include <string.h>

using namespace std;

void revWord(char* word, int l, int u) {
	while (l<u) {
		char temp = word[l];
		word[l] = word[u];
		word[u] = temp;
		l++; u--;
	}
}

void revWords(char* str, int len) {
	revWord(str,0,len-1);

	int l=0, u=0;
	while (u<len) {
		if (str[u+1]==' ' || str[u+1] == '\0') {
			revWord(str,l,u);
			u++;
			l=u+1;
		}
		u++;
	}
}

int main() {
	char str[] = "Do or do not, there is no try.";
	revWords(str,strlen(str));
	cout << str << endl;
}
