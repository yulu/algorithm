/*
 *sep 5 cci 1.3
 */
public class Permutation {
	public static void main(String[] args) {
		String s1 = "testi";
		String s2 = "testtest";

		System.out.println(isPermutation(s1, s2));
	}

	//whether a is a permutation of b
	public static boolean isPermutation(String a, String b) {
		int asize = a.length();
		int bsize = b.length();
		if(asize > bsize)
			return false;

		int a_i = 0;
		for(int i = 0; i < bsize; i++) {
			if (b.charAt(i) == a.charAt(a_i)) {
				a_i++;
				if(a_i == asize)
					return true;
			}
			else
				a_i = 0;
		}

		return false;
	}
}
