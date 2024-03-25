package Collections;

import java.util.Arrays; 
  
// Main class  
class ArraysInteger { 
    
    // Main driver method  
    public static void main(String[] args) 
    { 
        // Get the Array 
        int intArr[] = { 10, 20, 15, 22, 35 }; 
  
        // To convert the elements as List
        Arrays.asList(intArr);

        for(int i=0; i<intArr.length; i++){
            System.out.println(intArr.get(i));
        }
    } 
}