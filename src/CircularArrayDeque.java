/*

Implements some of the methods from the Deque interface with a circular array.

@author Tim Callies

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
    }
    
    public E first(){
        /*
        Returns the item at the beginning of the array.
        */
        if(size>0){
            return (E)myData[startLoc];
        }
        return null;
    }
    
    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        return (size==0);
    }
}//class