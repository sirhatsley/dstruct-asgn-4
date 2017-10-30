/*

Tests the methods of the CircularArrayDeque class

@author YOUR NAME HERE

*/

public class CircularArrayDequeDriver{

	public static void main(String[] args){
	
		MyDeque deck = new CircularArrayDeque<String>();
		
		//removeFirst on an empty Deque
		System.out.print("removeFirst on an empty Deque. Expected: null. Actual: ");
		System.out.println(deck.removeFirst());
		deck.addFirst("yoyo");
                deck.addLast("bat");
                System.out.print("addFirst on  Deque length 2. Expected: true. Actual: ");
                System.out.println(deck.addFirst("glove"));
                System.out.print("addLast on full Deque. Expected: false. Actual: ");
                System.out.println(deck.addLast("pan"));
                System.out.print("removeFirst on full Deque. Expected: glove. Actual: ");
                System.out.println(deck.removeFirst());
                System.out.print("size on Deque size 2. Expected: 2. Actual: ");
                System.out.println(deck.size());
                System.out.print("removeLast on Deque size 2. Expected: bat. Actual: ");
                System.out.println(deck.removeLast());
                System.out.print("removeLast on Deque size 1. Expected: yoyo. Actual: ");
                System.out.println(deck.removeLast());
	}//main



}//class