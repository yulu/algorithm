/*
 * Sep 9, cci 1.8
 */

public class StringRotation {

	public static void main(String[] args) {
		String s1 = "waterbottle";
		String s2 = "botlewater";
		System.out.println(isRotation(s1, s2));
	}

	//if s2 is a rotation of s1, s2 should be substring of s1s1
	public static boolean isRotation(String s1, String s2) {
		String s = s1+s1;
		//return s2.isSubString(s);
		return s.contains(s2);
	}
}
