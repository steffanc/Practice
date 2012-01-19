#include <iostream>
#include <map>
#include <string.h>

using namespace std;

bool allUnique(const char* str) {
	map<char,bool> uniq;
	unsigned len = strlen(str);

	for (unsigned i=0; i<len; ++i) {
		if(uniq[str[i]]==true) return false;
		else
			uniq[str[i]] = true;
	}
	return true;
}

bool allUniqueTwo(const char* str) {
	unsigned len = strlen(str);

	for (unsigned i=0; i<len-1; ++i)
		for (unsigned j=i+1; j<len; ++j)
			if (str[i] == str[j]) return false;

	return true;
}

int main() {
	const char* str = "abcdefg";

	if (allUnique(str))
		cout << "All unique" << endl;
	else
		cout << "NOT all unique" << endl;

	if (allUniqueTwo(str))
		cout << "All unique" << endl;
	else
		cout << "NOT all unique" << endl;

	return 0;
}
