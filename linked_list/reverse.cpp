#include <iostream>
#include <stdlib.h>

using namespace std;

struct node{
	int item;
	node* next;
	node(int x, node* t){
		item = x;
		next = t;
	}
};

typedef node* links;

links reverse(links head){
	links c, r, t;
	c = head;
	r = 0;
	while(c != 0){
		t = c->next;
		c->next = r;
		r = c;
		c = t;
	}

	return r;
}

int main(void){
	int n = 10;
	links head = new node(0, 0);
	links t = head;
	for(int i = 1; i < n; i++)
		t = (t->next = new node(i, 0));

	for(t = head; t != 0; t=t->next)
		cout<<t->item<<" ";
	cout<<endl;

	links r = reverse(head);

	for(t = r; t != 0; t = t->next)
		cout<<t->item<<" ";
	cout<<endl;

	return 0;
}
