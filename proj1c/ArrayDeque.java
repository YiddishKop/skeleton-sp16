/*
 * Double Ended Queue
 * 
 */
public class ArrayDeque<Item> implements Deque<Item>{
	private int size;
	private Item[] itemArray;
	private static final int INITIALSIZE = 10;
	private static final int FACTOR = 2;
	
	public static void main(String[] args) {
		ArrayDeque<Integer> ad= new ArrayDeque<Integer>();
		ad.addFirst(3);
		ad.addFirst(2);
		ad.addFirst(1);
		ad.addLast(4);
		ad.addLast(5);
		ad.addLast(6);
		ad.printDeque();
		ad.removeFirst();
		ad.removeLast();
		ad.printDeque();
	}
	
	public ArrayDeque() {
		size = 0;
		itemArray = (Item[])new Object[INITIALSIZE];
	}
	private void resize() {
		Item[] newItemArray =(Item[]) new Object[itemArray.length * FACTOR];
		// DONE 注意这里的通用类型数组的处理，只能用Object数组强转通用类型。
		for (int i = 0; i < itemArray.length; i++) {
			newItemArray[i] = itemArray[i];
		}
		itemArray = newItemArray;
	}
	@Override
	public Item removeFirst(){
		Item tmpItem = itemArray[0];
		// TODO 这里应该是引用赋值，还是内容赋值？
		int index = 1;
		while(index < size) { // 这里不应该使用数组长度作为比较边界，而应该使用Deque的size，因为你也不知道这么长的数组使用了多少
			itemArray[index - 1] = itemArray[index];
			index ++;
		}
		size -= 1;
		// 被空置的元素---原先尾元素的位置应该置“0”或者"null"
		itemArray[size] = null;
		return tmpItem;
	}
	@Override
	public void addFirst(Item it){
		// 先判断数组是否存满？
		if (size == itemArray.length) {
			resize();
		}else {
			// 这里应该从末尾元素逐渐后移，把位置逐个空出来，而不是从第一个元素
			int index = size-1;
			while(index >= 0) {
				itemArray[index + 1] = itemArray[index]; 
				index --;
			}
			itemArray[0] = it;
			size ++;
		}
	}
	@Override
	public Item removeLast(){
		// 直接末尾元素暂存，然后置“null”
		Item tmpItem = itemArray[size - 1];
		itemArray[size - 1] = null;
		size --;
		return tmpItem;
	}
	@Override
	public void addLast(Item it){
		if (size == itemArray.length) {
			resize();
		}else {
			itemArray[size] = it;
			size ++;
		}
	}
	@Override
	public void printDeque(){
		for(int i = 0; i < size; i++) {
			System.out.print(itemArray[i] + " ");
		}
	}
	@Override
	public boolean isEmpty(){
		return size == 0;
	}
	@Override
	public int size(){
		return size;
	}
	@Override
	public Item get(int index){
		return itemArray[index];
	}
}
