public class ArrayStack implements Stack{
    int size;
    Object [] data;
    
    public ArrayStack(){
        size=0;
        data = new Object[5];
    }
    

    public int size(){
        return size;
    }
    
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    
    public void push(Object e) throws StackOverflowException{
        
        if(size<data.length){
            data[size]=e;
            size++;
        }
        
        else{
            throw new StackOverflowException();
        }
    }
    
    public Object pop() throws StackUnderflowException{
        
        if(size>0){
            Object temp = data[size-1];
            data[size-1]=null;
            size--;
            return temp;
        }
        
        else{
            throw new StackUnderflowException();
        }
    }
    
    public Object peek() throws StackUnderflowException{
        
        if(size>0){
            return data[size-1];
        }
        
        else{
            throw new StackUnderflowException();
        }
    }
    
    public String toString(){
        
        String x = " ";
        
        if(size==0){
            return "Empty Stack";
        }
        
        for(int i=size-1; i>=0; i--){
            x = x + data[i]+" ";
        }
        
        return x;
    }
    
    public Object[] toArray(){
        
        Object[] a = new Object[size];
        
        for(int i=0, j=size-1; i<size; i++,j--){
            a[i]=data[j];
        }
        
        return a;
    }
    
    public int search(Object e){
        
        for(int i=size-1; i>=0; i--){
            if(data[i]==e){
                return (size-1-i);
            }
        }
        
        return -1;
    }
}