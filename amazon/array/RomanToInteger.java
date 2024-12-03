package array;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    public int romanToInt(String s) {
        /*
        I             1
        V             5
        X             10
        L             50
        C             100
        D             500
        M             1000
        */
        //Memory
        Map<Character, Integer> mem = new HashMap<>();
        mem.put('I', 1);
        mem.put('V', 5);
        mem.put('X', 10);
        mem.put('L', 50);
        mem.put('C', 100);
        mem.put('D', 500);
        mem.put('M', 1000);
        
        int buff = 1001;
        int number = 0;
        
        //Iterate; MCMXCIV; num = 1990; buff = 100
        //            ^ 
        for(int i=0; i<s.length(); i++){
            //Convert, 
            int digit = mem.get(s.charAt(i)); //1000
            
            // If num greater than buff decrease by 2*buff
            if(digit > buff){
                digit -= 2*buff;
            }
            
            //Add, 
            number += digit; 
            
            //update Buff
            buff = digit;
        }
            
        //Return
        return number;
    }
}

