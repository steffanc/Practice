#include <time.h>
#include <iostream>
#include <string.h>
#include <stdlib.h>
#include <math.h>

using namespace std;

const int deckSize=52;

void pDeck(int* d) {
	for (int i=0; i<deckSize; ++i)
		cout << d[i] << ", ";
	cout << endl;
	cout << endl;
}

void shuffle(int* deck) {
	for (int i=0; i<deckSize; ++i) {
		int index = rand()%(deckSize-i) + i;
		swap(deck[index],deck[i]);
	}
}

int main() {
	srand(time(NULL));
	int deck[deckSize];
	for (int i=0; i<deckSize; ++i) {
		deck[i]=i;
	}
	pDeck(deck);
	shuffle(deck);
	pDeck(deck);
	return 0;
}
