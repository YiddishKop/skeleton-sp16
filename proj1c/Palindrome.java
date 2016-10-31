
public class Palindrome {
	public static void main(String[] args) {
		String s1 = "0123456789";
		String s2 = "01234543210";
		String s3 = "0123443210";
		wordToDeque(s1).printDeque();
		wordToDeque(s2).printDeque();
		wordToDeque(s3).printDeque();
		System.out.println(isPalindrome(s1));
		System.out.println(isPalindrome(s2));
		System.out.println(isPalindrome(s3));
	}
	public static Deque<Character> wordToDeque(String word){ 
		// ��һ��String���͵ĵ��ʣ���˳����õ�Deque��
		Deque<Character> deqWord = new ArrayDeque<Character>();
		for (int i = 0; i < word.length(); i++) {
			deqWord.addLast(word.charAt(i));
		}
		return deqWord;
	}
	public static boolean isPalindrome(String word) {
		// �ж�һ�������Ƿ����
		if (word.length() == 0 || word.length() == 1) {
			return true;
		}else {
			char head = word.toCharArray()[0];
			char tail = word.toCharArray()[word.length() - 1];
			boolean isEqual =  head == tail;
			return isEqual && (isPalindrome(word.substring(1, word.length() - 1)));
		}
	}
	public static boolean isPalindrome(String word, CharacterComparator cc) {// cc����һ��usb�ڣ���������������ֻ���Ҳ���Գ��ֻ������Գ�usb̨��
		if (word.length() == 0 || word.length() == 1) {
			return true;
		}else {
			char head = word.toCharArray()[0];
			char tail = word.toCharArray()[word.length() - 1];
			boolean isEqual = cc.equalChars(head, tail);
			return isEqual && (isPalindrome(word.substring(1, word.length() - 1)));
		}
	}
}
