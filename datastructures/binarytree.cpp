#include <iostream>
#include <string.h>
#include <stdlib.h>

using namespace std;

template <class T>
class Node {
	private:
		Node* l;
		Node* r;
		T val;
	
	public:
		Node(T val); 
		~Node();
		Node* getLeft() const { return l; }
		void setLeft(Node<T>* _l) { l=_l; }
		Node* getRight() const { return r; }
		void setRight(Node<T>* _r) { r=_r; }
		T getVal() const { return val; }
};

template <class T>
Node<T>::Node(T _val):
	l(NULL),r(NULL),val(_val)
{}

template <class T>
Node<T>::~Node() {
	delete l;
	delete r;
}

template <class T>
void insert(Node<T>* root, const T& v) {
	if (root==NULL) return;
	if (v<root->getVal()) {
		if (root->getLeft()==NULL) root->setLeft(new Node<T>(v));
		else insert(root->getLeft(),v);
	} else {
		if (root->getRight()==NULL) root->setRight(new Node<T>(v));
		else insert(root->getRight(),v);
	}
}

// current, left, right
template <class T>
void preOrder(Node<T>* root) {
	if (root==NULL) return;
	cout << root->getVal() << ", ";
	preOrder(root->getLeft());
	preOrder(root->getRight());
}

// left, right, current
template <class T>
void postOrder(Node<T>* root) {
	if (root==NULL) return;
	postOrder(root->getLeft());
	postOrder(root->getRight());
	cout << root->getVal() << ", ";
}

// left, current, right
// good for binary trees
template <class T>
void inOrder(Node<T>* root) {
	if (root==NULL) return;
	inOrder(root->getLeft());
	cout << root->getVal() << ", ";
	inOrder(root->getRight());
}

// find the nth element in the tree using inOrder search
// left, current, right
template <class T>
Node<T>* findNthNode(Node<T>* root, int& pos, int n) {
	if (root==NULL) return NULL;
	Node<T>* temp = findNthNode(root->getLeft(),pos,n);
	if (temp!=NULL) return temp;
	if (pos==n) return root;
	pos++;
	return findNthNode(root->getRight(),pos,n);
}

// are nodes increasing in value from in order search
// left, current, right
template <class T>
bool isBSearchNode(Node<T>* root, int& last, bool& isInit) {
	if (root==NULL) return true;
	if (!isBSearchNode(root->getLeft(),last,isInit)) return false;
	if (!isInit) {
		last = root->getVal();
		isInit=true;
	} else {
		if (last > root->getVal()) return false;
		last = root->getVal();
	}
	return isBSearchNode(root->getRight(),last,isInit);
}

// 4_1 CTCI
// keep track of max and min depths of leaf nodes
// they should differ by more than 1
template <class T>
bool isBalanced(Node<T>* root, int depth, int& minDepth, int& maxDepth) {
	if (root==NULL) return true;
	if (!isBalanced(root->getLeft(), depth+1, minDepth, maxDepth)) return false;
	if (root->getLeft()==NULL && root->getRight()==NULL) {
		if (depth>maxDepth) maxDepth=depth;
		if (depth<minDepth) minDepth=depth;
		if ((maxDepth-minDepth)>1) return false;
	}
	return isBalanced(root->getRight(), depth+1, minDepth, maxDepth);
}

// 4_3 CTCI
// load sorted array into binary tree and keep height minimal
template <class T>
Node<T>* loadSortedNums(int* nums, int l, int u) {
	if (l>u) return NULL;
	int cur=(l+u)/2;
	Node<T>* temp = new Node<T>(nums[cur]);
	temp->setLeft(loadSortedNums<T>(nums,l,cur-1));
	temp->setRight(loadSortedNums<T>(nums,cur+1,u));
	return temp;
}

// 4_5 find next node of a given node
// template <class T>
// Node<T>* findNextNode(Node<T>* n) {
//	if (n->getRight()!=NULL) {
//		n=n->getRight();
//		while (n->getLeft()!=NULL)
//			n=n->getLeft();
//		return n;
//	}
//
//	Node<T>* par = n->getPar();
//	if (n->getPar()==NULL) return NULL;
//
//	if (par->getLeft()==n) return par;
//
//	n = par;
//	par = par->getPar();
//	while (par!=NULL) {
//		if (par->getRight!=n) return par;
//		n=par;
//		par=par->getPar();
//	}
//	return NULL;
// }

int main() {
	Node<int>* t = new Node<int>(3);

	// Node operations
	insert(t, 1);
	insert(t, 2);
	insert(t, 3);
	insert(t, 4);
	insert(t, 5);

	// Traversals
	cout << "Pre-Order: ";
	preOrder(t);
	cout << endl;
	cout << "Post-Order: ";
	postOrder(t);
	cout << endl;
	cout << "In-Order: ";
	inOrder(t);
	cout << endl;

	// find the nth element in the tree, start at 0 and go to n to keep count
	int pos=0;
	Node<int>* temp = findNthNode(t,pos,4);
	if (temp==NULL)
		cout << "NULL" << endl;
	else
		cout << temp->getVal() << endl;

	// binary search tree validation
	int last=0;
	bool isInit=false;
  cout << "Is a Binary Search Node: " << (isBSearchNode(t,last,isInit)?"true":"false") << endl;

	// 4_1 CTCI is the tree balanced
	int maxDepth=0, minDepth=0;
	cout << "Is Balanced: " << (isBalanced(t,0,minDepth,maxDepth)?"true":"false") << endl;

	// 4_3 CTCI load array of sorted numbers into the tree
	int len=8;
	int nums[] = {1,2,3,4,5,6,7,8};
	Node<int>* t2 =	loadSortedNums<int>(nums,0,len-1);
	inOrder(t2);

	// 4_5 find next node of a given node
	// findNextNode(Node* t);

	// 4_6 find the common ancestor
	//findAncestor(1,2);

	delete t;
	return 0;
}
