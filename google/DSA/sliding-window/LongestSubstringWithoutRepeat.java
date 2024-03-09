class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Using Sliding Window method
        //Convert string to CharArray
        //For a SW problem always try to make use of a HashMap or Set
        char[] charArr = s.toCharArray();
        
        int back = 0;
        int front = 0;
        int maxString = 0;
        
        Set<Character> visited = new HashSet<>();
        
        while(front < charArr.length){
            //c1: When curr is not visited move front
            if(!visited.contains(charArr[front])){
                visited.add(charArr[front]);
                front++;
            }
            else{
                visited.remove(charArr[back]);
                back++;
                continue;
            }
            
            maxString = Math.max(maxString, front - back);
        }
        return maxString;
    }
}