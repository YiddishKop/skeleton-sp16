import static org.junit.Assert.assertEquals;

import java.util.Formatter;

import sun.applet.Main;


/**
 * Scheme-like pairs that can be used to form a list of integers.
 *
 * @author P. N. Hilfinger, with some modifications by Josh Hug and melaniecebula
 *         [Do not modify this file.]
 */
public class IntList {
    /**
     * First element of list.
     */
    public int head;
    /**
     * Remaining elements of list.
     */
    public IntList tail;

    /**
     * A List with head HEAD0 and tail TAIL0.
     */
    public IntList(int head0, IntList tail0) {
        head = head0;
        tail = tail0;
    }

    /**
     * A List with null tail, and head = 0.
     */
    public IntList() {
    /* NOTE: public IntList () { }  would also work. */
        this(0, null);
    }

    /**
     * Returns a list equal to L with all elements squared. Destructive.
     */
    public static void dSquareList(IntList L) {

        while (L != null) {
            L.head = L.head * L.head;
            L = L.tail;
        }
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntList squareListIterative(IntList L) {
        if (L == null) {
            return null;
        }
        IntList res = new IntList(L.head * L.head, null);
        IntList ptr = res;
        L = L.tail;
        while (L != null) {
            ptr.tail = new IntList(L.head * L.head, null);
            L = L.tail;
            ptr = ptr.tail;
        }
        return res;
    }

    /**
     * Returns a list equal to L with all elements squared. Non-destructive.
     */
    public static IntList squareListRecursive(IntList L) {
        if (L == null) {
            return null;
        }
        return new IntList(L.head * L.head, squareListRecursive(L.tail));
    }

    /** DO NOT MODIFY ANYTHING ABOVE THIS LINE! */


    /**
     * Returns a list consisting of the elements of A followed by the
     * *  elements of B.  May modify items of A. Don't use 'new'.
     */

    public static IntList dcatenate(IntList A, IntList B) {
    	// use il scan A, if il.tail == null; than stop.
    	// make il.tail = B;
    	IntList il = A;
    	while(il.tail != null) {
    		il = il.tail;
    	}
    	il.tail = B;
        return A;
    }
    public static void main(String[] args) {
        IntList A = IntList.list(1, 2, 3);
        IntList B = IntList.list(4, 5, 6);
        IntList exp = IntList.list(1, 2, 3, 4, 5, 6);
        IntList.dcatenateRecursive(A, B);
	}
    public static IntList dcatenateRecursive(IntList A, IntList B) {
    	// use recursive method, catenate(Ð¡A£¬B)
    	// until A is null, than change 'null' to B
    	if(A.tail == null) {
    		A.tail = B;
    		return A;
    	}else {
    		/*
    		 * TODO A = 1,2,3;  B = 4,5,6;
    		 * this is good, answer is right
    		 * dcatenateRecursive(A.tail, B);
    		 * return A;
    		 */
    		/*
    		 * TODO A = 1,2,3;  B = 4,5,6;
    		 * this is bad, answer is only 3,4,5,6
    		 * return dcatenateRecursive(A.tail, B);
    		 */
    		dcatenateRecursive(A.tail, B);        
    		return A;
    	}
    }
    /**
     * Returns a list consisting of the elements of A followed by the
     * * elements of B.  May NOT modify items of A.  Use 'new'.
     */
    public static IntList catenate(IntList A, IntList B) {
    	// if A.tail not null, build a node, link it to the next
    	// until A.tail is null, link recent node.tail = B;
    	if (A == null) {
			return B;
		}else if(A.tail == null) {
			IntList il = new IntList(A.head, B);
			return il;
		}else {
			IntList iltail = catenate(A.tail, B);
			IntList il = new IntList(A.head, iltail);
			return il;
		}
    }


    /**
     * DO NOT MODIFY ANYTHING BELOW THIS LINE! Many of the concepts below here
     * will be introduced later in the course or feature some form of advanced
     * trickery which we implemented to help make your life a little easier for
     * the lab.
     */

    @Override
    public int hashCode() {
        return head;
    }

    /**
     * Returns a new IntList containing the ints in ARGS. You are not
     * expected to read or understand this method.
     */
    public static IntList list(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.tail) {
            p.tail = new IntList(args[k], null);
        }
        return result;
    }

    /**
     * Returns true iff X is an IntList containing the same sequence of ints
     * as THIS. Cannot handle IntLists with cycles. You are not expected to
     * read or understand this method.
     */
    public boolean equals(Object x) {
        if (!(x instanceof IntList)) {
            return false;
        }
        IntList L = (IntList) x;
        IntList p;

        for (p = this; p != null && L != null; p = p.tail, L = L.tail) {
            if (p.head != L.head) {
                return false;
            }
        }
        if (p != null || L != null) {
            return false;
        }
        return true;
    }

    /**
     * If a cycle exists in the IntList, this method
     * returns an integer equal to the item number of the location where the
     * cycle is detected.
     * <p>
     * If there is no cycle, the number 0 is returned instead. This is a
     * utility method for lab2. You are not expected to read, understand, or
     * even use this method. The point of this method is so that if you convert
     * an IntList into a String and that IntList has a loop, your computer
     * don't get stuck in an infinite loop.
     */

    private int detectCycles(IntList A) {
        IntList tortoise = A;
        IntList hare = A;

        if (A == null)
            return 0;

        int cnt = 0;


        while (true) {
            cnt++;
            if (hare.tail != null)
                hare = hare.tail.tail;
            else
                return 0;

            tortoise = tortoise.tail;

            if (tortoise == null || hare == null)
                return 0;

            if (hare == tortoise)
                return cnt;
        }
    }

    @Override
    /** Outputs the IntList as a String. You are not expected to read
     * or understand this method. */
    public String toString() {
        Formatter out = new Formatter();
        String sep;
        sep = "(";
        int cycleLocation = detectCycles(this);
        int cnt = 0;

        for (IntList p = this; p != null; p = p.tail) {
            out.format("%s%d", sep, p.head);
            sep = ", ";

            cnt++;
            if ((cnt > cycleLocation) && (cycleLocation > 0)) {
                out.format("... (cycle exists) ...");
                break;
            }
        }
        out.format(")");
        return out.toString();
    }
}

