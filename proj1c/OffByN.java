
public class OffByN implements CharacterComparator{
	private int offBy; 
	public OffByN(int n) {
		offBy = n;
	}
	@Override
	public boolean equalChars(char x, char y) {
		if (Math.abs(x - y) <= offBy) {
			return true;
		}else return false;
	}
}
