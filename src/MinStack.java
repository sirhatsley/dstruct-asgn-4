import java.util.NoSuchElementException;
/*

A stack that can return the minimum element currently in the stack

Creates 2 stacks, one stack which contains the data, and another stack which
contains the minimum values which as the stack progresses.

@author Tim Callies


Do not modify any of the method headers!
*/

public class MinStack<E extends Comparable<E>>{
    
    Node dataTail,minTail;
    //Do not modify this constructor header
    public MinStack(){
    }//constructor

    /*
    Pushes the element onto the top of this stack.

    @param toAdd the element to be added.

    */
    public void push(E toAdd){
        Node newNode = new Node(toAdd);
        if (dataTail==null){
            //Sets up the stack if it is currently empty
            dataTail=newNode;
            Node minNode = new Node(toAdd);
            minTail=minNode;
        }
        else{
            //Adds the new node to the stack.
            newNode.prev=dataTail;
            dataTail.next=newNode;
            if(toAdd.compareTo(dataTail.data)<=0){
                //Checks if the value of toAdd is less than or equal to the
                //value of the top item on a separate stack which only collects
                //the minimum values as the stack progresses.
                Node minNode = new Node(toAdd);
                minTail.next=minNode;
                minNode.prev=minTail;
                minTail=minNode;
            }
            dataTail=newNode;
        }
        /*
		O(1) because it creates a node, checks the top node on the
		minstack, and if it is greater than or equal to the new node, then that
		data is added onto the minstack as well. It never increments through
		either stack.
		*/
    }//push

    /*
    removes the element at the top of this stack and returns it.

    @return the element at the top of the stack.
    @throws NoSuchElementException if the stack is empty.

    */
    public E pop() throws NoSuchElementException{
        if(dataTail==null) {throw new NoSuchElementException();}
        E output;
        output = dataTail.data;
        if (dataTail.data.equals(minTail.data)){
            //If the value being removed is also on the minimum stack, then that
            //value is removed from the minimum stack as well.
            minTail=minTail.prev;
        }
        dataTail=dataTail.prev;
        return output;
		/*
		O(1) because it only accesses the top element on both stacks and
		compares them before removing them (or just removing one of them, if
		they do not have the same value.)
		*/
    }//pop

    /*
    finds and returns the smallest element in the stack.

    @return the minimum value in the stack.
    @throws NoSuchElementException if the stack is empty.
    */
    public E findMin() throws NoSuchElementException{
        if(dataTail==null) {throw new NoSuchElementException();}
        return minTail.data;
		/*
		O(1) Simply peeks at the first element on the minstack. No iteration
		required.
		*/
    }//findMin

    /*
    Returns true if the stack contains no elements.

    @true, if the stack contains no elements, false otherwise.
    */

    public boolean isEmpty(){
        return(dataTail==null);
		/*
		O(1). There is exactly one line of code and it is a boolean operation
		within a return statement.
		*/
    }//isEmpty
    
    /*
    This is a really basic Node inner class.
    Because I felt like writing my own stack.
    */
    private class Node{
        Node next;
        Node prev;
        E data;
        public Node(E data){
            this.data=data;
        }
    }
}//class