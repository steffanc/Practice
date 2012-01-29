#include <iostream>
#include <string.h>

// NOTES
// Hash Function
// - random and distributed evenly
// - can be predetermined
// 	- good to use if each element is unique, use a static int and increment for
// 	each new object created
// 	- object may already be a unique number
// - can be arithmentic
// 	- use if elements may be duplicates such as strings
// 	Ex.
// 		- take all chars or sample of chars (2^k -1) in a string
// 		(hash = 12347*hash + str[2^k-1])
// 	Ex.
// 		- least significant digit of number is said to be random
//
// Load Factor
// - # elements / # buckets
//
// Chained Hash Tables
// - each bin is associated with a linked list
// - hash function maps to bin and then push_front on linked list
// 	- use push front due to MRU algorithm
// - if load factor gets too large, then increase table size and possibly
// modify hash function
// - PROS easier to manage bins than array
// - CONS requires extra memory, dynamic memory, 
//
// Array Hash Table
// - load factor is always < 1
// - goal is to keep load factor under threshold
// 	- do this by choosing large array size
// CONS - removing an object is difficult since other objects need to then fill
// 	the gaps
// 

using namespace std;

template <class K, class V>
class HashTable {

}
