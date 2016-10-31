
public interface Deque<Item> {
	public Item removeFirst();
	public void addFirst(Item it);
	public Item removeLast();
	public void addLast(Item it);
	public void printDeque();
	public boolean isEmpty();
	public int size();
	public Item get(int index);
}
