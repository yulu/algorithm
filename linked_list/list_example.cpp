#include <iostream>
#include <list>
#include <algorithm>
#include <functional>

using namespace std;

void print_list(list<int> l){
	list<int> copy_l(l);
	while(!copy_l.empty()){
		cout<<copy_l.front()<<endl;
		copy_l.pop_front();
	}
}

int main(){
	list<int> lst1;		//lst1 is empty
	list<int> lst2(3,7);	//lst2 == (7, 7, 7)
	for(int j = 1; j <= 5; j++) //lst1 = (1 2 3 4 5)
		lst1.push_back(j);

	list<int>::iterator i1 = lst1.begin(), i2 = i1, i3;

	i2++; i2++; i2++;
	list<int> lst3(++i1, i2); //lst3 = (2 3)
	list<int> lst4(lst1); //lst4 = (1 2 3 4 5)
	
	//lst1
	cout<<"list 1"<<endl;
	print_list(lst1); 
	cout<<"list 2"<<endl;
	print_list(lst2); 
	cout<<"list 3"<<endl;
	print_list(lst3); 
	cout<<"list 4"<<endl;
	print_list(lst4);
	
	i1 = lst4.begin();
	lst4.splice(++i1, lst2);

	lst2 = lst1;			
	i2 = lst2.begin();	
	lst4.splice(i1, lst2, ++i2);	

	i2 = lst2.begin();
	i3 = i2;
	lst4.splice(i1, lst2, i2, ++i3);
	
	lst4.remove(1);
	lst4.sort();
	lst4.unique();
	lst1.merge(lst2);
	
	lst3.reverse();
	lst4.reverse();
	lst3.merge(lst4, greater<int>());

	lst3.remove_if(bind2nd(not_equal_to<int>(), 3));
	lst3.unique(not_equal_to<int>());

	print_list(lst3);

	return 0;
}
				
