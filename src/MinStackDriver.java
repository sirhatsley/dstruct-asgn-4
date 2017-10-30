/*

Tests the methods of the MinStack class

@author Tim Callies

*/
import java.util.NoSuchElementException;

public class MinStackDriver{

	public static void main(String[] args){

		 MinStack<Integer> minStack = new MinStack<Integer>();
		 
		 //findMin() on an empty stack
		 System.out.print("findMin() on an empty stack. Expected: NoSuchElementException. Actual: ");
		 try{
			System.out.println(minStack.findMin());
                 }
		 catch(NoSuchElementException e){
			System.out.println("NoSuchElementException Caught."); 
		 }//catch
	
		minStack.push(6);
                System.out.print("findMin() on an size-1 stack. Expected: 6. Actual: ");
                System.out.println(minStack.findMin());
                minStack.push(7);
                System.out.print("findMin() on an size-2 stack. Expected: 6. Actual: ");
                System.out.println(minStack.findMin());
                minStack.push(3);
                System.out.print("findMin() with a new min value. Expected: 3. Actual: ");
                System.out.println(minStack.findMin());
                System.out.print("pop(). Expected: 3. Actual: ");
                System.out.println(minStack.pop());
                System.out.print("findMin() with old value. Expected: 6. Actual: ");
                System.out.println(minStack.findMin());
                minStack.push(6);

	}//main

}//class