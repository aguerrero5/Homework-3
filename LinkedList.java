/***************************************************************************
 * List implementation using Nodes
 *****************************************************************************/

import java.util.*;

public class LinkedList<T> implements ListInterface<T>{
   private Node<T> head;

 /**
   *  Constructs an empty list
   */
   public LinkedList(){
      head = null;
   }
 /**
   *  Returns true if the list is empty
   */
   public boolean isEmpty(){
      return head == null;
   }
 /**
   *  Inserts a new node at the beginning of this list.
   */
   public void addFirst(T item){
      head = new Node<T>(item, head);
   }
 /**
   *  Returns the first element in the list.
   */
   public T getFirst(){
      if(head == null) throw new NoSuchElementException();

      return head.data;
   }
 /**
   *  Removes the first element in the list.
   */
   public T removeFirst(){
      T tmp = getFirst();
      head = head.next;
      return tmp;
   }
 /**
   *  Inserts a new node to the end of this list.
   */
   public void addLast(T item){
      if( head == null)
         addFirst(item);
      else
      {
         Node<T> tmp = head;
         while(tmp.next != null) tmp = tmp.next;

         tmp.next = new Node<T>(item, null);
      }
   }
 /**
   *  Returns the last element in the list.
   */
   public T getLast(){
      if(head == null) throw new NoSuchElementException();

      Node<T> tmp = head;
      while(tmp.next != null) tmp = tmp.next;

      return tmp.data;
   }
 /**
   *  Removes all nodes from the list.
   */
   public void clear(){
      head = null;
   }

 /**
   *  Returns the data at the specified position in the list.
   */
   public T get(int pos){
      if (head == null) throw new IndexOutOfBoundsException();

      Node<T> tmp = head;
      for (int k = 0; k < pos; k++) tmp = tmp.next;

      if( tmp == null) throw new IndexOutOfBoundsException();

      return tmp.data;
   }
 /**
   *  Returns a string representation
   */
   public String toString() {
    Node<T> node = head;
    StringBuffer result = new StringBuffer();
    while (node != null) {
      node = node.next;
      if (node != null) {
        result.append (" ==> ");
      }
    }
    return result.toString();
  }
 /**
   *  Inserts a new node after a node containing the anEntry.
   */
   public void insertAfter(T anEntry, T toInsert){
      Node<T> tmp = head;

      while(tmp != null && !tmp.data.equals(anEntry)) tmp = tmp.next;

      if(tmp != null)
         tmp.next = new Node<T>(toInsert, tmp.next);
   }
 /**
   *  Inserts a new node before a node containing the anEntry.
   */
   public void insertBefore(T anEntry, T toInsert){
      if(head == null) return;

      if(head.data.equals(anEntry))
      {
         addFirst(toInsert);
         return;
      }

      Node<T> prev = null;
      Node<T> cur = head;

      while(cur != null && !cur.data.equals(anEntry))
      {
         prev = cur;
         cur = cur.next;
      }
      //insert between cur and prev
      if(cur != null)
         prev.next = new Node<T>(toInsert, cur);
   }
 /**
   *  Removes the first occurrence of the specified element in this list.
   */
   public void remove(T anEntry){
      if(head == null)
         throw new RuntimeException("cannot delete");

      if( head.data.equals(anEntry) )
      {
         head = head.next;
         return;
      }

      Node<T> cur  = head;
      Node<T> prev = null;

      while(cur != null && !cur.data.equals(anEntry))
      {
         prev = cur;
         cur = cur.next;
      }

      if(cur == null)
         throw new RuntimeException("cannot delete");

      //delete cur node
      prev.next = cur.next;
   }
/////////////////////////////////////////////////////////////////////
   private static class Node<T>{
      private T data;
      private Node<T> next;

      public Node(T data, Node<T> next)
      {
         this.data = data;
         this.next = next;
      }
   }
}