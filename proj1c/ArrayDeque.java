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
		// DONE ע�������ͨ����������Ĵ���ֻ����Object����ǿתͨ�����͡�
		for (int i = 0; i < itemArray.length; i++) {
			newItemArray[i] = itemArray[i];
		}
		itemArray = newItemArray;
	}
	@Override
	public Item removeFirst(){
		Item tmpItem = itemArray[0];
		// TODO ����Ӧ�������ø�ֵ���������ݸ�ֵ��
		int index = 1;
		while(index < size) { // ���ﲻӦ��ʹ�����鳤����Ϊ�Ƚϱ߽磬��Ӧ��ʹ��Deque��size����Ϊ��Ҳ��֪����ô��������ʹ���˶���
			itemArray[index - 1] = itemArray[index];
			index ++;
		}
		size -= 1;
		// �����õ�Ԫ��---ԭ��βԪ�ص�λ��Ӧ���á�0������"null"
		itemArray[size] = null;
		return tmpItem;
	}
	@Override
	public void addFirst(Item it){
		// ���ж������Ƿ������
		if (size == itemArray.length) {
			resize();
		}else {
			// ����Ӧ�ô�ĩβԪ���𽥺��ƣ���λ������ճ����������Ǵӵ�һ��Ԫ��
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
		// ֱ��ĩβԪ���ݴ棬Ȼ���á�null��
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
