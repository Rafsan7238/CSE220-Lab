public class CircularArray{
    
    private int start;
    private int size;
    private Object [] cir;
    
    /*
     * if Object [] lin = {10, 20, 30, 40, null}
     * then, CircularArray(lin, 2, 4) will generate
     * Object [] cir = {40, null, 10, 20, 30}
     */
    public CircularArray(Object [] lin, int st, int sz){
        //TO DO
        
        cir=new Object [lin.length];
        start=st;
        size=sz;
        int idx=st;
        
        for(int j=0; j<sz; j++){
            cir[idx]=lin[j];
            idx=(idx+1)%cir.length;
        }
        
    }
    
    //Prints from index --> 0 to cir.length-1
    public void printFullLinear(){
        //TO DO
        
        System.out.println();
        for(int i=0; i<cir.length; i++){
            System.out.print(cir[i] + " ");
        }
    }
    
    // Starts Printing from index start. Prints a total of size elements
    public void printForward(){
        //To DO
        
        System.out.println();
        int idx=start;
        
        for(int i=0; i<size; i++){
            System.out.print(cir[idx] + " ");
            idx=(idx+1)%cir.length;
        } 
    }
    
    
    public void printBackward(){
        //TO DO
        
        System.out.println();
        int idx=(size-1+start)%cir.length;
        
        for(int i=0; i<size; i++){
            System.out.print(cir[idx] + " ");
            idx=idx-1;
            
            if(idx<0){
                idx=cir.length-1;
            }
        }
    }
    
    // With no null cells
    public void linearize(){
        //TO DO
        
        Object[] o=new Object[size];
        int idx=start;
        
        for(int i=0; i<size; i++){
            o[i]=cir[idx];
            idx=(idx+1)%cir.length;
        }
        
        cir=o;
        start=0;
    }
    
    // Do not change the Start index
    public void resizeStartUnchanged(int newcapacity){
        //TO DO
        
        Object[] o=new Object[newcapacity];
        int j=start;
        int k=start;
        
        for(int i=0; i<size; i++){
            o[j]=cir[k];
            j=(j+1)%o.length;
            k=(k+1)%cir.length;
        }
        
        cir=o;
    }
    
    // Start index becomes zero
    public void resizeByLinearize(int newcapacity){
        //TO DO
        
        if(newcapacity>=size){
            
            Object[] o=new Object[newcapacity];
            int j=0;
            int k=start;
            
            for(int i=0; i<size; i++){
                o[j]=cir[k];
                j++;
                k=(k+1)%cir.length;
            }
            
            cir=o;
            start=0;
        }
    }
    
    /* pos --> position relative to start. Valid range of pos--> 0 to size.
     * Increase array length by 3 if size==cir.length
     * use resizeStartUnchanged() for resizing.
     */
    public void insertByRightShift(Object elem, int pos){
        //TO DO
        
        if(pos>=0&&pos<=size){
            if(size==cir.length){
                resizeStartUnchanged(cir.length+3);
            }
            
            int j=(start+size-1)%cir.length;
            int k=(j+1)%cir.length;
            
            for(int i=0; i<size-pos; i++){
                cir[k]=cir[j];
                k=j;
                j--;
                
                if(j<0){
                    j=cir.length-1;
                }
            }
            
            cir[(start+pos)%cir.length]=elem;
            size++;
        }
    }
    
    public void insertByLeftShift(Object elem, int pos){
        //TO DO
        
        if(pos>=0&&pos<=size){
            if(size==cir.length){
                resizeStartUnchanged(cir.length+3);
            }
            
            int j=start;
            int k=j-1;
            
            if(k<0){
                k=cir.length-1;
            }
            
            for(int i=0;i<(pos+1)%cir.length;i++){ 
                
                cir[k]=cir[j];
                k=j;
                j=(j+1)%cir.length;
            }
            
            cir[(start+pos)%cir.length]=elem;
            size++;
            start=start-1;
            
            if(start<0){
                start=cir.length-1;
            }
        }
    }
    
    /* parameter--> pos. pos --> position relative to start.
     * Valid range of pos--> 0 to size-1
     */
    public void removeByLeftShift(int pos){
        //TO DO
        
        if(pos>=0&&pos<=size-1){
            
            int j=(start+pos)%cir.length;
            int k=(j+1)%cir.length; 
            
            for(int i=0; i<size-pos-1;i++){
                cir[j]=cir[k];
                j=k;                                  
                k=(k+1)%cir.length;
            }
            
            cir[(start+size-1)%cir.length]=null;
            size--;
            
            if(pos==0){
                start=(start+1)%cir.length;
            }
        }
    }
    
    
    /* parameter--> pos. pos --> position relative to start.
     * Valid range of pos--> 0 to size-1
     */
    public void removeByRightShift(int pos){
        //TO DO
        
        if(pos>=0&&pos<=size-1){
            
            int j=(start+pos)%cir.length;
            int k=j-1;
            
            if(k<0){
                k=cir.length-1;
            }
            
            for(int i=0; i<pos; i++){
                cir[j]=cir[k];
                j=k;
                k--;
                
                if(k<0){
                    k=cir.length-1;
                }
            }
            
            cir[start]=null;
            size--;
            start=(start+1)%cir.length;
        }
        
    }    
    
    
    //This method will check whether the array is palindrome or not
    public void palindromeCheck(){
        //TO DO
        
        System.out.println();
        
        int j=start;
        int k=(start+size-1)%cir.length;
        boolean palindrome=false;
        
        for(int i=0; i<size/2; i++){
            
            if(cir[j]==cir[k]){
                palindrome=true;
            }
            
            else{
                palindrome=false;
                break;
            }
            
            j=(j+1)%cir.length;
            k=k-1;
            
            if(k<0){
                k=cir.length-1;
            }
        }
        
        if(palindrome){
            System.out.println("This array is a palindrome.");
        }
        
        else{
            System.out.println("This array is NOT a palindrome.");
        }
    }
    
    
    //This method will sort the values by keeping the start unchanged
    public void sort(){
        //TO DO
        
//        -30 20 50 30 null 10 20   20 20 30 50 null -30 10  st=5 sz=6 
        
        for(int i=start; i<(start+size-1)%cir.length || i>=start; i=(i+1)%cir.length){
            
            for(int m=(i+1)%cir.length; m<=(start+size-1)%cir.length || m>start; m=(m+1)%cir.length){
                if(((Integer)cir[m]).intValue()<((Integer)cir[i]).intValue()){
                    Object temp=cir[i];
                    cir[i]=cir[m];
                    cir[m]=temp;
                    
                } 
                
            }  
            
        }
    }
    
    //This method will check the given array across the base array and if they are equivalent in terms of values return true, or else return false
    public boolean equivalent(CircularArray k){
        //TO DO
        
        System.out.println();
        
        linearize();
        k.linearize();
        
        if(cir.length==k.cir.length){
            
            boolean eql=false;
            
            for(int i=0; i<cir.length; i++){
                
                if(cir[i].equals(k.cir[i])){
                    eql=true;
                }
                
                else{
                    eql=false;
                    break;
                }
            }
            
            if(eql){
                return true;
            }
            
            else{
                return false;
            }
        }
        
        else{
            return false;
        }
    }
    
}
