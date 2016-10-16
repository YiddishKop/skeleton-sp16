/*
 * Deque = Double Ended Queue
 * In an empty Dequre, 'next'&'prev' of sentinel point to itself
 */
public class LinkedListDeque<Item> {
	public class Node{
		private Item item;
		private Node prev;
		private Node next;
		public Node() {
			item = null;
			next = null;
			prev = null;
		}
		public Node(Item item0, Node next0, Node prev0) {
			item = item0;
			next = next0;
			prev = prev0;
		}
	}
	private Node sentinel;
	private int size;
	public LinkedListDeque() {
		size = 0;
		sentinel = new Node();
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
	}
	public Node removeFirst() {
		Node tmpNode= sentinel.next;
		if (size != 0) {
			sentinel.next = tmpNode.next;
			tmpNode.next.prev = sentinel;
			size -= 1;
			return tmpNode;
		}else {
			return null;
		}
	}
	public void addFirst(Item item) {
		if (size != 0) {
			Node addNode = new Node(item, sentinel.next, sentinel.next.prev);
			sentinel.next.prev = addNode;
			sentinel.next = addNode;
			size += 1;
		}else {
			Node addNode = new Node(item, sentinel, sentinel);
			sentinel.next = addNode;
			sentinel.prev = addNode;
			size += 1;
		}
	}
	public Node removeLast() {
		Node tmpNode = sentinel.prev;
		if (size != 0) {
			 tmpNode.prev.next= sentinel;
			 sentinel.prev = tmpNode.prev;
			 size -= 1;
			 return tmpNode;
		}else {
			return null;
		}
	}
	public void addLast(Item item) {
		if (size != 0) {
			Node addNode = new Node(item, sentinel, sentinel.prev);
			addNode.prev.next = addNode;
			sentinel.prev = addNode;
			size += 1;
		}else {
			Node addNode = new Node(item, sentinel, sentinel);
			sentinel.next = addNode;
			sentinel.prev = addNode;
			size += 1;
		}
	}
	public Item get(int index) {
		// compare index with size/2;
		//     if >: loops prev;
		//     if <: loops next;
		Node tmpNode;
		int count;
		if (index >= size) {
			System.out.println("out of the lenth of Deque");
			return null;
		}else if(index <= size/2){
			tmpNode = sentinel.next;
			count = 0;  // count正好对应当前tmpNode指向Node的index
			while (count < index) {
				tmpNode = tmpNode.next;
				count += 1;
			}
			return tmpNode.item;
		}else {
			tmpNode = sentinel.prev;
			count = size - 1;  // count正好对应当前tmpNode指向Node的index
			while(count > index) {
				tmpNode = tmpNode.prev;
				count -= 1;
			}
			return tmpNode.item;
		}
	}
	public Item getRecursive(int index) {
		// 
		if (index == 0) {
			return sentinel.next.item;
		}else {
			LinkedListDeque<Item> lld = new LinkedListDeque<Item>();
			lld.sentinel = this.sentinel.next;
			index--;
			return lld.getRecursive(index);
			
		}
	}
	public void printDeque() {
		Node tmpNode = sentinel.next;
		while (tmpNode != sentinel) {
			System.out.println(tmpNode.item + " ");
			tmpNode = tmpNode.next;
		}
		System.out.println("empty, now!");
	}
	public boolean isEmpty() {
		return size() == 0;
	}
	public int size() {
		return size;
	}
	
	public static void main(String[] args) {
		LinkedListDeque<Integer> lld = new LinkedListDeque<Integer>();
		lld.addLast(0);
		lld.addLast(1);
		lld.addLast(2);
//		lld.addLast(3);
//		lld.addLast(4);
		System.out.println("length is: " + lld.size());
		lld.printDeque();
	}
	
}
