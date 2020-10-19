public class Recursion{
    
    public static int factorial(int i){
        if(i==0){
            return 1;
        }
        
        return i*factorial(i-1);
    }
    
    public static int fibonacci(int i){
        if(i<=2){
            return 1;
        }
        
        return fibonacci(i-1) + fibonacci (i-2);
    }
    
    public static void print(int[] a, int i){
        if(i<a.length){
            System.out.print(a[i] + " ");
            i++;
            print(a,i);
        }
    }
    
    public static String binary(int i){
        if(i==0){
            return "0";
        }
        
        return binary(i/2) + "" + (i%2);
    }
    
    public static int power(int m, int n){
        if(n!=0){
            return (m*power(m, n-1));
        }
        
        return 1;
    }
    
    public static int listSum(Node n){
        if(n!=null){
            return n.element + listSum(n.next);
        }
        
        return 0;
    }
    
    public static void reverseList(Node n){
        if(n!=null){
            reverseList(n.next);
            System.out.print(n.element + " ");
        }
    }
    
    public static void main(String[] args){
        
        System.out.println(factorial(5));
        System.out.println(fibonacci(6));
        
        int[] a = {10, 30, 50, 70, 90};
        print(a,0);
        System.out.println();
        
        System.out.println(binary(26));
        
        System.out.println(power(3,3));
        
        LinkedList l1 = new LinkedList(a);
        Node h = l1.head;
        listSum(h);
        
        reverseList(h);

    }
}