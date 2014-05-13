#include<iostream>
#include"genDLLst.h"

template<class T>
void DoublyLinkedList<T>::addToHead(const T& el){
	head = new DLLNode<T>(el, head, 0);
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
		head->prev = 0;
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
	
	list.printList();
	std::cout<<std::endl;

	std::cout<<list.deleteFromTail()<<std::endl;
	std::cout<<list.deleteFromHead()<<std::endl;

	list.printList();
}
