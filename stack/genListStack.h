#ifndef LL_STACK
#define LL_STACK

#include <list>
#include <algorithm>
#include <functional>

using namespace std;

template<class T>
class LLStack{
public:
	LLStack(){
	}

	void clear() {
		lst.clear();
	}

	bool isEmpty() const{
		return lst.empty();
	}

	T& topEl(){
		return lst.back();
	}

	T pop(){
		T el = lst.back();
		lst.pop_back();
		return el;
	}

	void push(const T& el){
		lst.push_back(el);
	}

private:
	list<T> lst;
};

#endif
