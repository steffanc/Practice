#include <iostream>
#include <stdlib.h>
#include <string.h>

using namespace std;

void queens(int* board, unsigned boardSize, unsigned row) {
  if (row==boardSize) {
    for (unsigned i=0; i<boardSize; ++i)
      cout << i << "," << board[i] << "  ";
    cout << endl;
  } else {
    for (int col=0; col<boardSize; ++col) {
      board[row] = col;
      bool success=true;
      for (int i=0; i<row; ++i) {
        if (board[i]==col | abs(i-row)==abs(board[i]-col)) {
          success=false;
          break;
        }
      }
      if (success) {
        queens(board,boardSize,row+1);
      }
    }
  }
}

int main() {
  unsigned boardSize = 8;
  int board[boardSize];
  queens(board,boardSize,0);
  return 0;
}
