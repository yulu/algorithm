/*
 *sep 5 cci 1.1
 */
public class UniqueString {
	public static void main(String[] args) {
		String test = "thiseloojke";
		System.out.println(isUnique(test));	
	}

	public static boolean isUnique(String s) {
		int size = s.length();
		if (size == 0)
			return false;

		for(int i = 0; i < size; i++) {
			char a = s.charAt(i);
			for(int j = i-1; j >= 0; j--) {
				if(a == s.charAt(j))
					return false;
			}
		}

		return true;
	}
}
