/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helloworld;

import java.util.Scanner;

/**
 *
 * @author walid.mohammad
 */
public class HelloWorld {
    
    public static boolean firstlast6(int[] arr){
        if(arr[0]==6 || arr[arr.length-1]==6){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a={2,3,4,6};
        int[] b={4,5,6,7,3};
        
        boolean aResult=firstlast6(a);
        System.out.println(aResult);
              
        boolean bResult=firstlast6(b);
        System.out.println(bResult);
        
    }
    
}
