#include <cstdlib>
#include <iostream>

using namespace std;

int main(){
	while(true){
		int n,n2, i, t;
		cin>>n;
		n2 = n;

		for(i = 0; n > 0; i++, n /= 2);
		cout<<"lgN is " <<i<<endl;

		for(i = 0, t = 1; t < n2; i++, t+=t);
		cout<<"lgN is "<<i<<endl;

	}

	return 0;
} 
