public class LinkedList{
    public Node head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the Node that contains the element from a[0]
     */ 
    public LinkedList(Object [] a){
        // TO DO
        
        Node n=new Node(a[0], null);
        head=n;
        
        for(int i=1; i<a.length; i++){
            n.next=new Node(a[i], null);
            n=n.next;
        }
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(Node h){
        // TO DO
        
        head=h;
    }
    
    /* Counts the number of Nodes in the list */
    public int countNode(){
        // TO DO
        
        System.out.println();
        
        Node n=head;
        int count=0;
        
        while(n!=null){
            count++;
            n=n.next;
        }
        return count; 
    }
    
    /* prints the elements in the list */
    public void printList(){
        // TO DO  
        
        Node n=head;
        while(n!=null){
            System.out.print(n.element + " ");
            n=n.next;
        }
        
    }
    
    // returns the reference of the Node at the given index. For invalid index return null.
    public Node nodeAt(int idx){
        // TO DO
        
        Node n=head;
        
        for(int i=0; i<idx && n!=null; i++){
            n=n.next; 
        }
        
        return n;
        
    }
    
    
// returns the element of the Node at the given index. For invalid idx return null.
    public Object get(int idx){
        // TO DO
        
        Node n=head;
        
        for(int i=0; i<idx && n!=null; i++){
            n=n.next;
        }
        if(n!=null){
            return n.element;
        }
        return null;
    }
    
    
    
    /* updates the element of the Node at the given index. 
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, Object elem){
        // TO DO
        
        if(idx>=0&&idx<this.countNode()){
            
            Node n=nodeAt(idx);
            Object temp=n.element;
            n.element=elem;
            return temp;
        }
        
        return null;
    }
    
    
    /* returns the index of the Node containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(Object elem){
        // TO DO
        
        Node n=head;
        
        for(int i=0; n!=null; i++){
            if(n.element==elem){
                return i;
            }
            
            n=n.next;
        }
        return -1; 
    }
    
    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(Object elem){
        // TO DO
        
        for(Node i=head; i!=null; i=i.next){
            if(i.element==elem){
                return true;
            }
            
        }
        
        return false; 
    }
    
    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public Node copyList(){
        // TO DO
        
        System.out.println();
        
        Node nodeHead=null;
        Node nodeTail=null;
        
        for(Node n=head; n!=null; n=n.next){
            Node newNode=new Node(n.element, null);
            
            if(nodeHead==null){
                nodeHead=newNode;
                nodeTail=nodeHead;
            }
            
            else{
                nodeTail.next=newNode;
                nodeTail=nodeTail.next;
            }
        }
        
        
        return nodeHead;
    }
    
    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
            public Node reverseList(){
                // TO DO
                
                if(head!=null){
                    Node n = head;
                    Node newHead = new Node (head.element, null);
                    n=n.next;
                   
                    while(n!=null){
                        Node x = new Node (n.element, null);
                        x.next = newHead;
                        newHead = x;
                        n=n.next;
                    }
                    
                    return newHead;
                }
                
                return null;
            }
                
    
    /* inserts Node containing the given element at the given index
     * Check validity of index.
     */
    public void insert(int elem, int idx){
        // TO DO
        
        if(idx<0 || idx>this.countNode()){
            System.out.println("Invalid index");
        }
        
        Node n=new Node(elem,null);
        
        if(idx==0){
            n.next=head;
            head=n;
        }
        
        else{
            
            Node temp=nodeAt(idx-1);
            n.next=temp.next;
            temp.next=n;
        }
    }
    
    
    /* removes Node at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public int remove(int index){
        // TO DO
        
        if(index<0 || index>this.countNode()){
            return null;
        }
        
        Node n=head;
        
        if(index==0){
            Object temp=n.element;
            head=n.next;
            return temp;
        }
        
        else{
            
            Node a=nodeAt(index);
            Node b=nodeAt(index-1);
            
            Object temp=a.element;
            b.next=a.next;
            return temp;
        }
 
    }
    
    // Rotates the list to the left by 1 position.
    public void rotateLeft(){
        // TO DO
        
        Node n=head;
        
        head=n.next;
        
        nodeAt(countNode()-1).next=n;
        n.next=null;
    }
    
    // Rotates the list to the right by 1 position.
    public void rotateRight(){
        // TO DO
        
        int i=countNode()-1;
        Node n=nodeAt(i);
        n.next=head;
        head=n;
        nodeAt(i).next=null;
    }
    
    public boolean palindrome(Node h){
        
        Node a=h;
        Node n=h;
        int j=0;
        boolean match=false;
        
        for(Node m=n; n!=null; n=n.next){
            j++;
        }
        
        for(int i=0, k=j-1; i<k; i++, k--, a=a.next){
            
            Node b=h;
            
            while(b.next!=n){
                b=b.next;
            }
            
            if(b.element==a.element){
                match=true;
                n=b;
            }
            
            else{
                match=false;
                break;
            }
        }
        
        return match;
    }
    
}