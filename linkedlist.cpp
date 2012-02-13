#include <iostream>
#include <string.h>

using namespace std;

//template <class T>
//class LinkedList {
	//private:
		//Node<T>* head;
		//int size;

	//public:
		//LinkedList();
		//~LinkedList();
		//Node<T>* getHead() const { return head; }
		//int getSize() const { return size; }
		//void addNode(T val);
//};

template <class T>
class Node {
	template <class> friend class LinkedList;
	public:
		T val;
		Node* next;
	public:
		Node(T _val);
		~Node();
		void setVal(T _val) { val=_val; }
		T getVal() const { return val; }
		void setNext(Node* _next) { next=_next; }
		Node* getNext() const { return next; }
};

template <class T>
Node<T>::Node(T _val):
	val(_val),next(NULL)
{}

template <class T>
Node<T>::~Node()
{}

template <class T>
void addNode(Node<T>** head, T val) {
	if ((*head)==NULL) {
		(*head) = new Node<T>(val);
	} else {
		Node<T>* n = (*head);
		while (n->next!=NULL) {
			n=n->next;
		}
		n->next = new Node<T>(val);
	}
}

template <class T>
void deleteNode(Node<T>** head, T val) {
	if ((*head)==NULL) {
		return;
	} else if ((*head)->val==val) {
		Node<T>* temp = (*head);
		(*head) = (*head)->next;
		delete temp;
	} else {
		Node<T>* n = (*head)->next;
		Node<T>* p = (*head);
		while (n!=NULL) {
			Node<T>* temp = NULL;
			if (n->val==val) {
				temp = n;
				p->next=n->next;
			}
			p=p->next;
			n=n->next;
			if (temp!=NULL)
				delete temp;
		}
	}
}

template <class T>
void pList(Node<T>* head) {
	Node<T>* t = head;
	while (t!=NULL) {
		cout << t->val << ", ";
		t=t->next;
	}
	cout << endl;
}

template <class T>
Node<T>* reverse(Node<T>** node) {
	if (*(node)->next==NULL) {
		(*head)=n;
		return (*head);
	} else {
		reverse(head,n->next,lev+1)->next = n;
		if (lev==0) n->next=NULL;
		return n;
	}
}

template <class T>
Node<T>* reverse2(Node<T>** head) {
	if (n->next==NULL) {
		(*head)=n;
		return (*head);
	} else {
		reverse(head,n->next,lev+1)->next = n;
		if (lev==0) n->next=NULL;
		return n;
	}
}

template <class T>
void deleteList(Node<T>** head) {
	if ((*head)!=NULL) {
		deleteList(&((*head)->next));
		delete (*head);
		(*head)=NULL;
	}
}

int main() {
	Node<int>* head = NULL;
	addNode(&head, 1);
	addNode(&head, 2);
	addNode(&head, 3);
	pList(head);
	reverse(&head,head,0);
	pList(head);
	deleteNode(&head,1);
	deleteNode(&head,2);
	deleteNode(&head,4);
	pList(head);
	deleteList(&head);
	return 0;
}
