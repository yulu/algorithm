/*
 * Sep 7 cci 1.5
 */
public class Compression {
	
	public static void main(String[] args) {
		String test = "ajiddd";
		System.out.println(compression(test));		
	}

	public static String compression(String s) {
		int count=1;
		int size = s.length();
		String output = s.substring(0,1);
		char p = s.charAt(0);

		for (int i = 1; i < size; i++) {
			char c = s.charAt(i);
			if(c == p) {
				count++;
			}else{
				output += Integer.valueOf(count);
				output += c;
				count = 1;
			}
			p = c;
		}

		output += Integer.valueOf(count);
	
		return output.length() < s.length()? output:s;
	}
}
