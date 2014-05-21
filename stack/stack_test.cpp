#include <iostream>
#include "genListStack.h"

int char_to_int(char c){
	int r = c - '0';
	if(r >= 0 && r <= 9)
		return r;
	else 
		return -1;
}

LLStack<int> push_num_to_stack(char* num){

	int i = 0;
	LLStack<int> num_stack;
	char* end=num;
	while(*end){
		int r = char_to_int(*end);
		if(r != -1)
			num_stack.push(r);
		end++;
	}

	return num_stack;
}

int main(void){

	char* num1 = "12345678";
	char* num2 = "123456";

	LLStack<int> s1, s2, sum;
	s1 = push_num_to_stack(num1);
	s2 = push_num_to_stack(num2);

	int carry = 0;
	while(true){
		if( s1.isEmpty() && s2.isEmpty())
			break;

		int i = 0, j = 0, r = 0;
		if( !s1.isEmpty() )
			i = s1.pop();
		if( !s2.isEmpty() )
			j = s2.pop();
		
		r = (carry + i + j)%10; //ge wei
		carry = (carry + i + j)/10; //shi wei

		sum.push(r);
	}

	while(true){
		if(sum.isEmpty())
			break;

		std::cout<<sum.pop();
	}
	cout<<endl;

	return 0;
}
		
