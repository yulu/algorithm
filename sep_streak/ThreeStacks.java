/*
 * Sep 17, cci 3.1 use single array to implement three stacks
 */
public class ThreeStacks {
	public static void main(String[] args) {

	}

	private int[] stackHolder;
	private int length = 64;

	private int idx1, idx2, idx2l, idx2r, idx3;

	public ThreeStacks() {
		stackHolder = new int[length];
		idx1 = 0; 
		idx3 = length - 1;
		idx2l = idx2r = length / 2;
	}

	public void pushToStack1(int v) {
		if ((idx1+1) >= idx2l)
			throw Exceptions();
		
		stackHolder[++idx1] = v;
	}

	public void pushToStack2(int v) {
		if (idx2 == idx2l) {
			if((idx2 - 1) <= idx1)
				throw Exceptions();
			
			stackHolder[--idx2l] = v;
			idx2 = idx2r;
		} else {
			if((idx2 + 1) >= idx3)
				throw Exceptions();
		
			stackHolder[++idx3] = v;
			idx2 = idx2l;
		}
	}

	public void pushToStack3(int v) {
		if ((idx3 - 1) <= idx2r)
			throw Exceptions();

		stackHolder[--idx3] = v;
	}

	public int popStack1() {
		if (idx1 > = 0)
			return stackHolder[idx1--];
		else 
			throw Exceptions();
	}

	public int popStack2() {
		if (idx2 == length / 2)
			throw Exceptions();
		if (idx2 = idx2l) {
			idx2 = idx2r;
			return stackHolder[idx2l++];
		} else {
			idx2 = idx2l;
			return stackHolder[idx2r--];
		}
			
	}

	public int popStack3() {
		if (idx3 == length - 1) 
			throw Exceptions();
		else
			return stackHolder[idx3++];
	} 

}
