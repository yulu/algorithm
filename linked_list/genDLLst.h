#ifndef DOUBLY_LINKED_LIST
#define DOUBLY_LINKED_LIST

template<class T>
class DLLNode{
public:
	DLLNode(){
		next = prev = 0;
	}
	DLLNode(const T& el, DLLNode *n = 0, DLLNode *p = 0){
		info = el; next = n; prev = p;
	}
	T info;
	DLLNode *next, *prev;
};

template<class T>
class DoublyLinkedList{
public:
	DoublyLinkedList(){
		head = tail = 0;
	}
	void addToTail(const T&);
	void addToHead(const T&);
	T deleteFromHead();
	T deleteFromTail();
	void printList();
	//more member functions can be added
protected:
	DLLNode<T> *head, *tail;
};

#endif
