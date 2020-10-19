import java.util.*;

public class DoublyList{
    public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public DoublyList(Object [] a){
        head = new Node(null, null, null);
        Node tail = head;
        
        for(int i = 0; i<a.length; i++){
            Node mn = new Node(a[i], null, null);
            tail.next = mn;
            mn.prev=tail;
            tail=tail.next;
        }
        tail.next=head; // Making it circular
        head.prev=tail;
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public DoublyList(Node h){
        head = h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
        // TO DO
        
        System.out.println();
        
        int count=0;
            
        for(Node n=head.next; n!=head; n=n.next){
                count++;
            }
        
        return count; 
    }
    
    /* prints the elements in the list */
    public void forwardprint(){
        // TO DO 
        
        System.out.println();
        
        for(Node n=head.next; n!=head; n=n.next){
            System.out.print(n.element + " ");
        }
    }
    
    public void backwardprint(){
        // TO DO 
        
        System.out.println();
        
        for(Node n=head.prev; n!=head; n=n.prev){
            System.out.print(n.element + " ");
        }
    }
    
    
    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        // TO DO
        
        Node n=head.next;
        
        for(int i=0; i<idx && n!=head; i++){
            n=n.next;
        }
        
        if(idx>=0 && n!=head){
            return n;
        }
        
        return null; 
    }
    
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        // TO DO
        
        Node n=head.next;
        
        for(int i=0; n!=head; i++, n=n.next){
            if(n.element==elem){
                return i;
            }
        }
  
        return -1; 
    }
    
    
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(Object elem, int idx){
        // TO DO
        
        int j=countNode();
        Node n=nodeAt(idx);
        
        Node x=new Node(elem, null, null);
        
        if(idx>=0 && idx<j){
            x.next=n;
            x.prev=n.prev;
            x.prev.next=x;
            n.prev=x;
        } 
        
        else if(idx==j){
            x.next=head;
            x.prev=head.prev;
            x.prev.next=x;
            head.prev=x;
        }
        
        else{
            System.out.println("Invalid index!");
        }
    }
    
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        // TO DO
        
        System.out.println();
        
        int j=countNode();
        
        if(index>=0 &&  index<j){
            Node n=nodeAt(index);
            n.prev.next=n.next;
            n.next.prev=n.prev;
            
            return n.element;
        }
        
        return null; 
    }
    
    
    
}