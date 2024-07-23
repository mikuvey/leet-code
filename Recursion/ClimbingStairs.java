class Solution {
    //Very important concept for Memoizaiton and DP
    //Must watch(neetCOde): https://www.youtube.com/watch?v=Y0lT9Fck7qI
    Map<Integer, Integer> cache = new HashMap<>();
    
    public int climbStairs(int n) {
        return climb(0, n);
    }
    
    public int climb(int i, int n){
        if(i == n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        
        if(cache.containsKey(i)){
            return cache.get(i);
        }
        
        int res = climb(i+1, n) + climb(i+2, n);
        cache.put(i, res);
        
        return res;
    }
}