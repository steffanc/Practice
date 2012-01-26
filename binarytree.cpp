#include <iostream>
#include <string.h>
#include <stdlib.h>

using namespace std;

template <class T>
class Tree {
	private:
		Tree* l;
		Tree* r;
		T* val;
	
	public:
		Tree(Tree* l, Tree* r, T* val); 
		~Tree();
		Tree* getLeft() const { return l; }
		void setLeft(Tree<T>* _l) { l=_l; }
		Tree* getRight() const { return r; }
		void setRight(Tree<T>* _r) { r=_r; }
		T* getVal() const { return val; }
};

template <class T>
Tree<T>::Tree(Tree* _l, Tree* _r, T* _val):
	l(_l),r(_r),val(_val)
{}

template <class T>
Tree<T>::~Tree() {
	delete l;
	delete r;
	delete val;
}

// current, left, right
template <class T>
void preOrder(Tree<T>* root) {
	if (root==NULL) return;
	cout << *(root->getVal()) << ", ";
	preOrder(root->getLeft());
	preOrder(root->getRight());
}

// left, right, current
template <class T>
void postOrder(Tree<T>* root) {
	if (root==NULL) return;
	postOrder(root->getLeft());
	postOrder(root->getRight());
	cout << *(root->getVal()) << ", ";
}

// left, current, right
// good for binary trees
template <class T>
void inOrder(Tree<T>* root) {
	if (root==NULL) return;
	inOrder(root->getLeft());
	cout << *(root->getVal()) << ", ";
	inOrder(root->getRight());
}

// find the nth element in the tree using inOrder search
// left, current, right
template <class T>
Tree<T>* findN(Tree<T>* root, int& pos, int n) {
	if (root==NULL) return NULL;
	Tree<T>* temp = findN(root->getLeft(),pos,n);
	if (temp!=NULL) return temp;
	if (pos==n) return root;
	pos++;
	return findN(root->getRight(),pos,n);
}

// are nodes increasing in value from in order search
// left, current, right
template <class T>
bool isBSearchTree(Tree<T>* root, int& last, bool& isInit) {
	if (root==NULL) return true;
	if (!isBSearchTree(root->getLeft(),last,isInit)) return false;
	if (!isInit) {
		last = *(root->getVal());
		isInit=true;
	} else {
		if (last > *(root->getVal())) return false;
		last = *(root->getVal());
	}
	return isBSearchTree(root->getRight(),last,isInit);
}

// 4_1 CTCI
// keep track of max and min depths of leaf nodes
// they should differ by more than 1
template <class T>
bool isBalanced(Tree<T>* root, int depth, int& minDepth, int& maxDepth) {
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
Tree<T>* loadSortedNums(int* nums, int l, int u) {
	if (l>u) return NULL;
	int cur=(l+u)/2;
	Tree<T>* temp = new Tree<T>(NULL,NULL,new int(nums[cur]));
	temp->setLeft(loadSortedNums<T>(nums,l,cur-1));
	temp->setRight(loadSortedNums<T>(nums,cur+1,u));
	return temp;
}

int main() {
	Tree<int>* t = new Tree<int>(
			new Tree<int>(NULL, NULL, new int(1)),
			new Tree<int>(new Tree<int>(NULL,new Tree<int>(NULL,NULL,new int(4)),new int(3)),NULL, new int(5)),
			new int(2));
	preOrder(t);
	cout << endl;
	postOrder(t);
	cout << endl;
	inOrder(t);
	cout << endl;
	int pos=0;
	Tree<int>* temp = findN(t,pos,4);
	if (temp==NULL)
		cout << "NULL" << endl;
	else
		cout << *(temp->getVal()) << endl;

	int last=0;
	bool isInit=false;
  cout << "Is a Binary Search Tree: " << (isBSearchTree(t,last,isInit)?"true":"false") << endl;
	// 4_1 CTCI
	int maxDepth=0, minDepth=0;
	cout << "Is Balanced: " << (isBalanced(t,0,minDepth,maxDepth)?"true":"false") << endl;

	// 4_3 CTCI
	int len=8;
	int nums[] = {1,2,3,4,5,6,7,8};
	Tree<int>* t2 =	loadSortedNums<int>(nums,0,len-1);
	inOrder(t2);

	delete t;
	return 0;
}
