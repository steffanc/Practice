#include <iostream>
#include <map>
#include <string.h>

using namespace std;

bool isAnagram(char* str1, char* str2) {
	unsigned len1 = strlen(str1);
	unsigned len2 = strlen(str2);

	if (len1 != len2) return false;

	map<char,unsigned> ana;

	for (unsigned i=0; i<len1; ++i)
		ana[str1[i]]++;

	for (unsigned i=0; i<len2; ++i) {
		if (ana[str2[i]] == 0) return false;
		ana[str2[i]]--;
	}
}

int main() {
	char str1[] = "abc";
	char str2[] = "caa";

	if (isAnagram(str1,str2))
		cout << "IS anagram" << endl;
	else
		cout << "IS NOT anagram" << endl;
}
