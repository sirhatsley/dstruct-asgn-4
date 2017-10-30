/*

Implements some of the methods from the Deque interface with a circular array.

@author Tim Callies

Note: When a comment refers to moving an index forward or backward, assume that
it is accounting for the looping structure of the array.

*/

public class CircularArrayDeque<E> implements MyDeque<E>{

    private final int CAPACITY = 3;
    private Object[] myData;
    private int size;
    private int startLoc;

    //Do not modify this constructor header
    public CircularArrayDeque(){
        myData = new Object[CAPACITY];
        size=0;
        startLoc=0;
    }//constructor

    public boolean addFirst(E toAdd){
        /*
        Adds a new item to the start of the circular array
        */
        if (size>=CAPACITY){
            return false;
        }
        //Moves the starting location of the array back by one and places the
        //new object in the empty space.
        startLoc=(startLoc+CAPACITY-1)%CAPACITY;
        myData[startLoc]=toAdd;
        size++;
        return true;
		/*
		O(1): Moves the startLoc back by one, and places a new item in the new
		placement. No need to increment through the rest of the array.
		*/
    }
    
    public E removeFirst(){
        /*
        Removes the first item in the circular array
        */
        E output = null;
        if (size>0){
            //Moves the starting location of the array forward one and removes
            //the object in the original starting location.
            output = (E)myData[startLoc];
            myData[startLoc]=null;
            startLoc=(startLoc+1)%CAPACITY;
            size--;
        }
        return output;
		/*
		O(1): Sets the data at startLoc to null, and moves the startLoc forward
		one. No need to increment through the rest of the array.
		*/
    }
    
    public boolean addLast(E toAdd){
        /*
        Adds a new item to the end of the circular array
        */
        if(size>=CAPACITY){
            return false;
        }
        //Places the item at the end of the array.
        myData[(startLoc+size)%CAPACITY]=toAdd;
        size++;
        return true;
		/*
		O(1) If possible, places the new data in startLoc+size.
		No need to increment through the rest of the array.
		*/
    }
   
    public E removeLast(){
        /*
        Removes the item at the end of the array.
        */
        E output=null;
        if(size>0){
            //Finds the location of the last item in the array, removes it and
            //returns it.
            output = (E)myData[(startLoc+size-1)%CAPACITY];
            size--;
            return output;
        }
		/*
		O(1): Sets the data at startLoc+size-1 to null and decrements the size.
		No need to increment through the rest of the array.
		*/
        return output;
    }

    public E last(){
        /*
        Returns the item at the end of the array.
        */
        if(size>0){
            return (E)myData[(startLoc+size)%CAPACITY];
        }
        return null;
		/*
		O(1) Simply returns the item at the end of the array.
		*/
    }
    
    public E first(){
        /*
        Returns the item at the beginning of the array.
        */
        if(size>0){
            return (E)myData[startLoc];
        }
        return null;
		/*
		O(1): Simply returns the item at the startLoc
		*/
    }
    
    public int size(){
        return size;
		/*
		O(1): Returns the size of the array.
		*/
    }
    
    public boolean isEmpty(){
        return (size==0);
		/*
		O(1): Returns if size=0.
		*/
    }
}//class