/*
 * Sep 6 cci 1.4
 */

public class Replace {
	public static void main(String[] args) {
		char[] test="this is a test                      ".toCharArray();
		replace(test, 14);
		System.out.println(test);		
	}

	public static void replace(char[] input, int length) {
		int newLength = length;
		for(int i = 0; i < newLength; i++) {
			if (input[i] == ' ') {
				newLength += 2;
				replaceIt(input, i, newLength);
				i += 2;
			}
		}
	}

	private static void replaceIt(char[] input, int i, int newLength) {
		int j;
		for(j = newLength; j > i; j--) {
			input[j+2] = input[j];
		}
		input[i] = '%';
		input[i+1] = '2';
		input[i+2] = '0';
	}
}
