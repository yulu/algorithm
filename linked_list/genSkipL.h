#ifndef SKIPLIST_H
#define SKIPLIST_H

const int maxLevel = 4;

template<class T>
class SkipListNode{
public:
	SkipListNode(){
	}
	T key;
	SkipListNode **next;
};

template<class T>
class SkipList{
public:
	SkipList();
	bool isEmpty() const;
	void choosePowers();
	int chooseLevel();
	T* skipListSearch(const T&);
	void skipListInsert(const T&);
private:
	typedef SkipListNode<T> *nodePtr;
	nodePtr root[maxLevel];
	int powers[maxLevel];
};

#endif
