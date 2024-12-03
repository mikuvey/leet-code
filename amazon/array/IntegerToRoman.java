package array;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
    public String intToRoman(int num) {
        /*
        
        Symbol	Value
        I	1
        V	5
        X	10
        L	50
        C	100
        D	500
        M	1000
        
        501/10 = 50; 501%10 = 1 5%10 = 
        {1:1, 10:0, 100: 5}
        */
        
        //Memory
        Map<Integer, Character> mem = new HashMap<>();
        mem.put(1,   'I');
        mem.put(5,   'V');
        mem.put(10,  'X');
        mem.put(50,  'L');
        mem.put(100, 'C');
        mem.put(500, 'D');
        mem.put(1000,'M');
        
        //Getting numbers from Right to Left
        //Dividing by 10 untill we get all the digits; assign them with their respective units
        
        /*
        MMMDCCXLIX
        3749
        {1:9, 10:4, 100:7, 1000:3}
        */
        int extract = num;
        int tenUnit = 1;
        
        Map<Integer, Integer> digitMap = new HashMap<>();
        
        while(extract != 0){
            digitMap.put(tenUnit, extract%10);
            extract /= 10;
            tenUnit *= 10;
        }
        
        //Result
        StringBuilder roman = new StringBuilder();
        
        //Based on unit appending Roman Numeral to output
        //Mapping digits with roman
        for(int i=1000; i>0; i/=10){
            //Is it 4 or 9
            //Is it 5
            //Is it 1
            //Is it less than 5 and not 4
            //Is it greater than 5 and not 9
            //MMMLCC
            if(!digitMap.containsKey(i)){
                continue;
            }
            
            int digit = digitMap.get(i); //7
            char unit = mem.get(i); //C

            
            if(digit == 4){
                char midUnit = mem.get(i*5);
                roman.append(unit).append(midUnit);
            }
            
            else if(digit == 9){
                char nextUnit = mem.get(i*10);
                roman.append(unit).append(nextUnit);
            }
            
            else if(digit == 5){
                char midUnit = mem.get(i*5);
                roman.append(midUnit);
            }
            
            else if(digit < 4){
                for(int j=0; j<digit; j++){
                    roman.append(unit);
                }
            }
            
            else if(digit > 5 && digit < 9){
                char midUnit = mem.get(i*5); //L
                roman.append(midUnit); 
                for(int j=5; j<digit; j++){
                    roman.append(unit);
                }
            }
        }
        
        //Return Roman
        return roman.toString();
    }
}

