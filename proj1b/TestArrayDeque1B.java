import org.junit.Test;
import static org.junit.Assert.*;

public class TestArrayDeque1B {
	@Test
	public void sizeTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		FailureSequence fs1 = new FailureSequence();
		int expected1 = 0;
		int actual1 = sad1.size();
		DequeOperation do1 = new DequeOperation("size");
		fs1.addOperation(do1);
		assertEquals(fs1.toString(), expected1, actual1);
		// 上一个assertEquals没有产生错误，默认就重新开辟一个函数名调用集合
		FailureSequence fs2 = new FailureSequence();
		sad1.addFirst(4);
		DequeOperation do2 = new DequeOperation("addFirst", 4);
		fs2.addOperation(do2);
		sad1.addLast(5);
		DequeOperation do3 = new DequeOperation("addLast", 5);
		fs2.addOperation(do3);
		sad1.addLast(6);
		DequeOperation do4 = new DequeOperation("addLast", 6);
		fs2.addOperation(do4);
		sad1.removeFirst();
		DequeOperation do5 = new DequeOperation("removeFirst");
		fs2.addOperation(do5);
		sad1.removeLast();
		DequeOperation do6 = new DequeOperation("removeFirst");
		fs2.addOperation(do6);
		sad1.removeLast();
		DequeOperation do7 = new DequeOperation("removeFirst");
		fs2.addOperation(do7);
		sad1.removeLast();
		DequeOperation do8 = new DequeOperation("removeFirst");
		fs2.addOperation(do8);
		int expected = 0;
		int actual = sad1.size();
		assertEquals(fs2.toString() , expected, actual);
	}
	@Test
	public void addFirstTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		sad1.addFirst(4);
		sad1.addFirst(3);
		sad1.addFirst(2);
		sad1.addFirst(1);
		sad1.addFirst(0);
		for (int i = 0; i < 5; i++) {
			int actual = sad1.get(i);
			int expected = i;
			assertEquals(expected, actual);
		}
	}
	@Test
	public void removeFirstTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		sad1.addFirst(4);
		sad1.addFirst(3);
		sad1.addFirst(2);
		sad1.addFirst(1);
		sad1.addFirst(0);
		StudentArrayDeque<Integer> sad2 = new StudentArrayDeque<Integer>();
		sad2.addLast(0);
		sad2.addLast(1);
		sad2.addLast(2);
		sad2.addLast(3);
		sad2.addLast(4);
		for (int i = 0; i < sad1.size(); i++) {
			assertEquals(sad1.get(i), sad2.get(i));
		}
		int actual1 = sad1.removeFirst();
		int expected1 = 0;
		assertEquals(expected1, actual1);
		sad1.removeFirst();
		for (int i = 2; i < 5; i++) {
			int actual = sad1.get(i-2);
			int expected = i;
			assertEquals(expected, actual);
		}
	}
	@Test
	public void addLastTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		sad1.addLast(0);
		sad1.addLast(1);
		sad1.addLast(2);
		sad1.addLast(3);
		sad1.addLast(4);
		for (int i = 0; i < 5; i++) {
			int actual = sad1.get(i);
			int expected = i;
			assertEquals(expected, actual);
		}
	}
	@Test
	public void removeLastTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		sad1.addFirst(4);
		sad1.addFirst(3);
		sad1.addFirst(2);
		sad1.addFirst(1);
		sad1.addFirst(0);
		int actual_size = sad1.size();
		int expected_size = 5;
		assertEquals(expected_size, actual_size);
		for (int i = 0; i < 5; i++) {
			sad1.removeLast();
		}
		int actual = sad1.size();
		int expected = 0;
		assertEquals(expected, actual);
	}
	@Test
	public void getTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		sad1.addFirst(4);
		sad1.addFirst(3);
		sad1.addFirst(2);
		for (int i = 0; i < sad1.size(); i++) {
			int expected = i + 2;
			int actual = sad1.get(i);
			assertEquals(expected, actual);
		}
	}
	@Test
	public void isEemptyTest() {
		StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<Integer>();
		boolean actual1 = sad1.isEmpty();
		boolean expected1 = true;
		assertEquals(expected1, actual1);
		sad1.addFirst(4);
		sad1.addFirst(3);
		sad1.addFirst(2);
		sad1.addFirst(1);
		sad1.addFirst(0);
		sad1.removeFirst();
		sad1.removeFirst();
		sad1.removeFirst();
		sad1.removeFirst();
		sad1.removeFirst();
		boolean actual = sad1.isEmpty();
		boolean expected = true;
		assertEquals(expected, actual);

	}

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestArrayDeque1B.class);
    }
}
