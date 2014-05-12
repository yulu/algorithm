#ifndef INT_LINKED_LIST
#define INT_LINKED_LIST

class IntSLLNode{
public:
	int info;
	IntSLLNode *next;
	IntSLLNode(int el, IntSLLNode *ptr=0){
		info = el; next = ptr;
	}
};

class IntSLList{
public:
	IntSLList(){
		head=tail=0;
	}

	~IntSLList();
	int isEmpty(){
		return head == 0;
	}
	void addToHead(int);
	void addToTail(int);
	int deleteFromHead();
	int deleteFromTail();
	void deleteNode(int);
	bool isInList(int) const;
	void printList();
private:
	IntSLLNode *head, *tail;
};	

#endif
