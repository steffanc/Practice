#include <iostream>
#include <string.h>

using namespace std;

void pParen(unsigned in, char* out, unsigned nO, unsigned nC, unsigned lev) {
  if (nO==0 & nC==0) cout << out << endl;
  else {
    if(nO <= nC) {
      out[lev]='(';
      pParen(in,out,nO-1,nC,lev+1);
    }
    if(nO < nC) {
      out[lev]=')';
      pParen(in,out,nO,nC-1,lev+1);
    }
  }
}

int main() {
  unsigned in = 6;
  char out[in*2];
  out[in*2]='\0';
  pParen(in,out,in,in,0);
  return 0;
}
