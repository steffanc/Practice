#include <iostream>
#include <string.h>

using namespace std;

void cents(unsigned tar, unsigned cur, char* out, unsigned pos, unsigned lev) {
  if (cur==tar) {
    out[lev]='\0';
    cout << out << endl;
  } else {
    switch (pos) {
      case 0:
        if (cur+25 <= tar) {
          out[lev]='a';
          cents(tar,cur+25,out,0,lev+1);
          out[lev]=' ';
        }
      case 1:
        if (cur+10 <= tar) {
          out[lev]='b';
          cents(tar,cur+10,out,1,lev+1);
          out[lev]=' ';
        }
      case 2:
        if (cur+5 <= tar) {
          out[lev]='c';
          cents(tar,cur+5,out,2,lev+1);
          out[lev]=' ';
        }
      case 3:
        if (cur+1 <= tar) {
          out[lev]='d';
          cents(tar,cur+1,out,3,lev+1);
          out[lev]=' ';
        }
    }
  }
}

int main() {
  char out[100];
  cents(25,0,out,0,0);
  return 0;
}
