package RecursionI.PrincipleOfRecursion;

public class ReverseString {
	public static void main(String[] args) {
		char[] s = new char[5];
		s[0] = 'h';
		s[1] = 'e';
		s[2] = 'l';
		s[3] = 'l';
		s[4] = 'o';
		reverseString(s);
	}

	public static void reverseString(char[] s) {
		int length = s.length - 1;
		for(int i = 0 ; i < s.length / 2 ; i++) {
			char temp = s[i];
			s[i] = s[length];
			s[length] = temp;
			length--;
		}
		
		for(int i = 0 ; i < s.length ; i++) {
			System.out.println(s[i]);
		}
		
	}
 
}
