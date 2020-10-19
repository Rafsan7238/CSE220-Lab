package lab07;

public class ListStack implements Stack{
	  int size;
	  Node top;
	  
	  
	  public ListStack(){
	    size = 0;
	    top = null;
	  }
	  
	  public int size(){
	    return size;
	  }
	  
	  public boolean isEmpty(){
	    if(top==null){
	      return true;
	    }
	    return false;
	  }
	  
	  public void push(Object e) throws StackOverflowException{
	    
	    Node n=new Node(e, null);
	    if(size!=0){
	      n.next=top;
	      top=n;
	      size++;
	    }
	    
	    else{
	      top=n;
	      size++;
	    }
	  }
	  
	  public Object pop() throws StackUnderflowException{
	    
	    if(size!=0){
	      Object temp=top.val;
	      top=top.next;
	      size--;
	      return temp;
	    }
	    
	    else{
	      throw new StackUnderflowException();
	    }
	  }
	  
	  public Object peek() throws StackUnderflowException{
	    
	    if(size!=0){
	      return top.val;
	    }
	    
	    else{
	      throw new StackUnderflowException();
	    }
	  }
	  
	  public String toString(){
	    
	    String x=" ";
	    
	    if(size==0){
	      return "Empty Stack";
	    }
	    
	    for(Node n=top; n!=null; n=n.next){
	      x = x + n.val + " ";
	    }
	    
	    return x;
	  }
	  
	  public Object[] toArray(){
	    
	    Object [] o=new Object[size];
	    if(size!=0){
	      Node n=top;
	      
	      for(int i=0; i<size; i++, n=n.next){
	        o[i]=n.val;
	      }
	    }
	    return o;
	  }
	  
	  public int search(Object e){
	    
	    if(size!=0){
	      Node n=top;
	      
	      for(int i=0; n!=null; n=n.next,i++){
	        if(n.val==e){
	          return i;
	        }
	      }
	    }
	    return -1;
	  }
	  
	  public boolean parenthesis(String s){
	    char[] c=s.toCharArray();
	    for(int i=0; i<c.length; i++){
	      
	      try{
	        if(c[i]=='('||c[i]=='{'||c[i]=='['){
	          push(c[i]);
	        }
	      }
	      
	      catch(Exception e){
	        System.out.println(e);
	      }
	      
	      try{
	        
	        if(c[i]==')'){
	          if((char)peek()=='('){
	            pop();
	          }
	          
	          else{
	            return false;
	          }
	        }
	        
	        if(c[i]=='}'){
	          if((char)peek()=='{'){
	            pop();
	          }
	          
	          else{
	            return false;
	          }
	        }
	        
	        if(c[i]==']'){
	          if((char)peek()=='['){
	            pop();
	          }
	          
	          else{
	            return false;
	          }
	        }
	      }
	      
	      catch(Exception e){
	        System.out.println("Invalid");
	      }
	    }
	    
	    if(size!=0){
	      return false;
	    }
	    
	    else{
	      return true;
	    }
	  }
	}
