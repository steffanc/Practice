#include <iostream>
#include <string.h>

using namespace std;

void permute(char* str, char* out, bool* used, unsigned len, unsigned lev) {
  if(lev==len) {
    out[len]='\0';
    cout << out << endl;
  }
  else {
    for (unsigned i=0; i<len; ++i) {
      if (!used[i]) {
        out[lev]=str[i];
        used[i]=true;
        permute(str,out,used,len,lev+1);
        used[i]=false;
      }
    }
  }
}

int main() {
  char str[] = "abc";
  unsigned len = strlen(str);
  char* out = new char[len];
  bool used[len];
  for (unsigned i=0; i<len; ++i) {
    used[i]=false;
  }
  permute(str,out,used,len,0);
}
