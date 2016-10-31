import org.junit.Test;
import static org.junit.Assert.*;

public class TestLinkedListDeque1B {
	@Test
	public void addFirstTest() {
		//
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		slld1.addFirst(3);
		slld1.addFirst(2);
		slld1.addFirst(1);
		slld1.addFirst(0);
		for (int i = 0; i < 4; i++) {
			int actual = slld1.get(i);
			int expected = i;
			assertEquals(expected, actual);
		}
		
	}
	@Test
	public void removeFirstTest() {
		//
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		slld1.addFirst(3);
		slld1.addFirst(2);
		slld1.addFirst(1);
		slld1.addFirst(0);
		for (int i = 0; i < 4; i++) {
			int actual = slld1.removeFirst();
			int expected = i;
			assertEquals(expected, actual);
		}
	}
	@Test
	public void removeLastTest() {
		// TODO 找到了，removeLast导致空指针问题
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		slld1.addFirst(3);
		slld1.addFirst(2);
		slld1.addFirst(1);
		slld1.addFirst(0);
		int actual1 = slld1.removeLast();
		int expected1 = 3;
		assertEquals(expected1, actual1);
		for (int i = 0; i < 3; i++) {
			int actual = slld1.get(i);
			int expected = i;
			assertEquals(expected, actual);
		}
	}
	@Test
	public void addLastTest() {
		//
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		slld1.addLast(0);
		slld1.addLast(1);
		slld1.addLast(2);
		slld1.addLast(3);
		for (int i = 0; i < 4; i++) {
			int actual = slld1.get(i);
			int expected = i;
			assertEquals(expected, actual);
		}
	}
	@Test
	public void getTest() {
		//
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		Object actual = slld1.get(3);
		Object expected = null;
		assertEquals(expected, actual);
	}
	@Test
	public void isEmptyTest() {
		//
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		int actual = slld1.size();
		int expected = 0;
		assertEquals(expected, actual);
	}
	
	public static void main(String[] args) {
		StudentLinkedListDeque<Integer> slld1 = new StudentLinkedListDeque<Integer>();
		System.out.println(slld1.size());
		System.out.println(slld1.isEmpty());
		System.out.println(slld1.removeFirst());
		System.out.println(slld1.size());
		System.out.println(slld1.isEmpty());
		System.out.println(slld1.removeLast());
		System.out.println(slld1.size());
		System.out.println(slld1.isEmpty());
		slld1.addFirst(3);
		slld1.addFirst(2);
		slld1.addFirst(1);
		slld1.addFirst(0);
		slld1.printDeque();
		slld1.addLast(4);
		slld1.addLast(5);
		slld1.printDeque();
		slld1.removeFirst();
		slld1.removeFirst();
		slld1.printDeque();
		slld1.removeLast();
		slld1.printDeque();
//		System.out.println(slld1.size());
//		for (int i = 0; i < 4; i++) {
//			slld1.removeFirst();
//			System.out.println(slld1.size());
//		}
//		slld1.printDeque();
//		System.out.println(slld1.removeFirst());
	}   
}
