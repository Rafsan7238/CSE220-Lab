public class LinkedList{
    public Node head;
     
    public LinkedList(int [] a){
        
        Node n=new Node(a[0], null);
        head=n;
        
        for(int i=1; i<a.length; i++){
            n.next=new Node(a[i], null);
            n=n.next;
        }
    }
}
