
public interface ListInterface<T>{
	/**returns true if List is empty/else return false*/
 public boolean isEmpty();
 
   /**adds item to the beginning of list*/
 public void addFirst(T item);
 
  /** retrieves first item*/
 public T getFirst();
 
   /** removes last item*/
 public T removeFirst();
 
  /**adds item to the end of list*/
 public void addLast(T item);
 
 /** retrieves last item*/
 public T getLast();
 
 /** clears out the list*/
 public void clear();
 
 /** returns all list items to string*/
 public String toString();
 
 /** removes a specfic item*/
 public void remove(T anEntry);
 } 