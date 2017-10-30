



public interface MyDeque<E>{
	/*
	adds the given element to the beginning of the deque.
	
		@param the element to be added.
		
		@returns true, if successfully added, false otherwise.
	*/
	public boolean addFirst(E toAdd);
	
	/*
	adds the given element to the end of the deque.
	
		@param the element to be added.
		
		@returns true, if successfully added, false otherwise.
	*/
	public boolean addLast(E toAdd);
	
	/*
	Removes and returns the element stored at the beginning of the deque.
	
		@return the first element in the deque, null otherwise.
	*/
	public E removeFirst();
	
	/*
	Removes and returns the element stored at the end of the deque.
	
		@return the last element in the deque, null otherwise.
	*/
	public E removeLast();
	
	/*
	Returns the element stored at the beginning of the deque, without removing it.
	
		@return the first element in the deque, null otherwise.
	*/
	public E first();
	
	/*
	Returns the element stored at the end of the deque, without removing it.
	
		@return the last element in the deque, null otherwise.
	*/
	public E last();
	
	/*
	returns the number of elements with the deque.
	
		@return the number of elements within the deque
	*/
	public int size();
	
	/*
	Returns true if the deque contains no elements.
	
		@return true if the deque contains no elements, false otherwise
	*/
	public boolean isEmpty();


}