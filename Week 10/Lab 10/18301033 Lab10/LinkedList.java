public class LinkedList{
    public SinglyNode head;
    
    
    /* First Constructor:
     * Creates a linked list using the values from the given array. head will refer
     * to the SinglyNode that contains the element from a[0]
     */ 
    public LinkedList(int [] a){
        // TO DO
        
        SinglyNode n=new SinglyNode(a[0], null);
        head=n;
        
        for(int i=1; i<a.length; i++){
            n.next=new SinglyNode(a[i], null);
            n=n.next;
        }
    }
    
    /* Second Constructor:
     * Sets the value of head. head will refer
     * to the given LinkedList
     */
    public LinkedList(SinglyNode h){
        // TO DO
        
        head=h;
    }
    
    /* Counts the number of SinglyNodes in the list */
    public int countSinglyNode(){
        // TO DO
        
        System.out.println();
        
        SinglyNode n=head;
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
        
        SinglyNode n=head;
        while(n!=null){
            System.out.print(n.element + " ");
            n=n.next;
        }
        
    }
    
    // returns the reference of the SinglyNode at the given index. For invalid index return null.
    public SinglyNode nodeAt(int idx){
        // TO DO
        
        SinglyNode n=head;
        
        for(int i=0; i<idx && n!=null; i++){
            n=n.next; 
        }
        
        return n;
        
    }
    
    
// returns the element of the SinglyNode at the given index. For invalid idx return null.
    public Object get(int idx){
        // TO DO
        
        SinglyNode n=head;
        
        for(int i=0; i<idx && n!=null; i++){
            n=n.next;
        }
        if(n!=null){
            return n.element;
        }
        return null;
    }
    
    
    
    /* updates the element of the SinglyNode at the given index. 
     * Returns the old element that was replaced. For invalid index return null.
     * parameter: index, new element
     */
    public Object set(int idx, int elem){
        // TO DO
        
        if(idx>=0&&idx<this.countSinglyNode()){
            
            SinglyNode n=nodeAt(idx);
            Object temp=n.element;
            n.element=elem;
            return temp;
        }
        
        return null;
    }
    
    
    /* returns the index of the SinglyNode containing the given element.
     if the element does not exist in the List, return -1.
     */
    public int indexOf(int elem){
        // TO DO
        
        SinglyNode n=head;
        
        for(int i=0; n!=null; i++){
            if(n.element==elem){
                return i;
            }
            
            n=n.next;
        }
        return -1; 
    }
    
    // returns true if the element exists in the List, return false otherwise.
    public boolean contains(int elem){
        // TO DO
        
        for(SinglyNode i=head; i!=null; i=i.next){
            if(i.element==elem){
                return true;
            }
            
        }
        
        return false; 
    }
    
    // Makes a duplicate copy of the given List. Returns the reference of the duplicate list.
    public SinglyNode copyList(){
        // TO DO
        
        System.out.println();
        
        SinglyNode nodeHead=null;
        SinglyNode nodeTail=null;
        
        for(SinglyNode n=head; n!=null; n=n.next){
            SinglyNode newSinglyNode=new SinglyNode(n.element, null);
            
            if(nodeHead==null){
                nodeHead=newSinglyNode;
                nodeTail=nodeHead;
            }
            
            else{
                nodeTail.next=newSinglyNode;
                nodeTail=nodeTail.next;
            }
        }
        
        
        return nodeHead;
    }
    
    // Makes a reversed copy of the given List. Returns the head reference of the reversed list.
            public SinglyNode reverseList(){
                // TO DO
                
                int[] a = new int[countSinglyNode()];
                SinglyNode n=head;
                
                for(int i=0; i<a.length; i++){
                    a[i]=n.element;
                    n=n.next;
                }
                
                for(int i=0, j=a.length-1; i<j; i++, j--){
                    int temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
                
                LinkedList b=new LinkedList(a);
                return b.head;
            }
    
    /* inserts SinglyNode containing the given element at the given index
     * Check validity of index.
     */
    public void insert(int elem, int idx){
        // TO DO
        
        if(idx<0 || idx>this.countSinglyNode()){
            System.out.println("Invalid index");
        }
        
        SinglyNode n=new SinglyNode(elem,null);
        
        if(idx==0){
            n.next=head;
            head=n;
        }
        
        else{
            
            SinglyNode temp=nodeAt(idx-1);
            n.next=temp.next;
            temp.next=n;
        }
    }
    
    
    /* removes SinglyNode at the given index. returns element of the removed node.
     * Check validity of index. return null if index is invalid.
     */
    public Object remove(int index){
        // TO DO
        
        if(index<0 || index>this.countSinglyNode()){
            return null;
        }
        
        SinglyNode n=head;
        
        if(index==0){
            Object temp=n.element;
            head=n.next;
            return temp;
        }
        
        else{
            
            SinglyNode a=nodeAt(index);
            SinglyNode b=nodeAt(index-1);
            
            Object temp=a.element;
            b.next=a.next;
            return temp;
        }
 
    }
    
    // Rotates the list to the left by 1 position.
    public void rotateLeft(){
        // TO DO
        
        SinglyNode n=head;
        
        head=n.next;
        
        nodeAt(countSinglyNode()-1).next=n;
        n.next=null;
    }
    
    // Rotates the list to the right by 1 position.
    public void rotateRight(){
        // TO DO
        
        int i=countSinglyNode()-1;
        SinglyNode n=nodeAt(i);
        n.next=head;
        head=n;
        nodeAt(i).next=null;
    }
    
    public boolean palindrome(SinglyNode h){
        
        SinglyNode a=h;
        SinglyNode n=h;
        int j=0;
        boolean match=false;
        
        for(SinglyNode m=n; n!=null; n=n.next){
            j++;
        }
        
        for(int i=0, k=j-1; i<k; i++, k--, a=a.next){
            
            SinglyNode b=h;
            
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