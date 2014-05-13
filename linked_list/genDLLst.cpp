#include<iostream>
#include"genDLLst.h"

template<class T>
void DoublyLinkedList<T>::addToHead(const T& el){
	head = new DLLNode<T>(el, head, 0);
	head->next->prev = head; //this is important: after adding a new node at the head, should let its succussor point back to it.
	if(tail == 0)
		tail = head;
}

template<class T>
void DoublyLinkedList<T>::addToTail(const T& el){
	 if(tail != 0){
		tail = new DLLNode<T>(el, 0, tail);
		tail->prev->next = tail;
	}
	else head = tail = new DLLNode<T>(el);
}

template<class T>
T DoublyLinkedList<T>::deleteFromHead(){
	T el = head->info;
	if(head == tail){
		head = tail = 0;
	}else{
		DLLNode<T> *tmp;
		tmp = head;
		head = head->next; 
		delete tmp;
		head->prev = 0; //this is important: after let the head point to its succussor, should let this new head point back to null
	}
	return el;
}

template<class T>
T DoublyLinkedList<T>::deleteFromTail(){
	T el = tail->info;
	if(head == tail){
		delete head;
		head = tail = 0;
	}
	else{
		tail = tail->prev;
		delete tail->next;
		tail->next = 0;
	}
	return el;
}

template<class T>
void DoublyLinkedList<T>::printList(){
	DLLNode<T> *tmp;
	for(tmp = head; tmp != 0; tmp=tmp->next)
		std::cout<<tmp->info<<" ";
}

int main(void){
	DoublyLinkedList<char> list;

	list.addToTail('c');
	list.addToHead('b');
	list.addToTail('a');
	list.addToHead('d');
	for(int i =0; i < 10; i++){
		list.addToHead('*');
	}
	

	for(int i = 0; i < 12; i++){
		std::cout<<list.deleteFromTail()<<std::endl;
	}

	list.printList();
}
