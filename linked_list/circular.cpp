#include <iostream>
#include <stdlib.h>

using namespace std;

struct node
{
	int item;
	node* next;
	node(int x, node* t){
		item = x;
		next = t;
	}
};

typedef node *links;

int main(int argc, char *argv[])
{
	int i;
	int N = atoi(argv[1]);

	links t = new node(1, 0);
	t->next =t;
	links x = t;
	for(i = 2; i <= N; i++)
		x = (x->next = new node(i, t));

	x = t;
	do{
		cout<<x->item<<endl;
		x = x->next;
	}while(x != t);

	return 0;
}
