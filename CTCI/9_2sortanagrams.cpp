#include <iostream>
#include <string.h>

using namespace std;

bool isAnagram(char* s1, char* s2) {
  int l1=strlen(s1), l2=strlen(s2);
  if(l1!=l2) return false;

  int asciiLen = 256;
  int ascii[asciiLen];
  for (int i=0; i<asciiLen; ++i)
    ascii[i]=0;

  for (int i=0; i<l1; ++i)
    ascii[int(s1[i])]++;

  for (int i=0; i<l2; ++i) {
    if (ascii[int(s2[i])]==0) return false;
    ascii[i]--;
  }
  return true;
}

void sortAnagrams(char** str, int len) {
  for (int i=0; i<len; ++i) {
    int aCount=0;
    for (int j=i+1; j<len; ++j) {
      if (isAnagram(str[i],str[j])) {
        aCount++;
        char* temp = str[i+aCount];
        str[i+aCount]=str[j];
        str[j]=temp;
      }
    }
    i+=aCount;
  }
}

int main() {
  char* strs[] = {"da","ab","ac","ba","ca","ab","ad"};
  int len = 7;
  sortAnagrams(strs, len);
  for (int i=0; i<len; ++i)
    cout << strs[i] << endl;
  return 0;
}
