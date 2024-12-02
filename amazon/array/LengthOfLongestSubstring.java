package array;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        pwwkew      front=5 low= c=w    {w:2}
             ^
          |
        */
        //cache; 2ptrs
        Map<Character, Integer> cache = new HashMap<>();
        int back = 0;
        int maxLen = 0;
        
        //Edge
        if(s.length() == 0){
            return maxLen;
        }
            
        //Iterate
        for(int front=0; front<s.length(); front++){
            char c = s.charAt(front);
            
            //Reset ptrs
            if(cache.containsKey(c)){
                //Move low ptr and delete all the data till the 1st dup
                int i = cache.get(c);
                while(back <= i){
                    //*****Make sure to pass through a variable(i) else will result Null pointer error*****
                    cache.remove(s.charAt(back));
                    back++;
                }
            }
            
            //Update cache; 
            cache.put(c, front);
            //update max
            maxLen = Math.max(cache.size(), maxLen);  
        }
        
        //Ret max
        return maxLen;
    }
}