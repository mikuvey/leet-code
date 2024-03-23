class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        //Initializaitons
        List<List<Integer>> result = new ArrayList<>();
        
        //Use a loop to iterate over elements in the nums being aware of lower and upper ranges
        int len = nums.length;
        
        //edge:
        if(len == 0){
            result.add(Arrays.asList(lower,upper));
            return result;
        }
        
        //Cases:
        //1. lower is < nums[0]
        if(nums[0] > lower) {
            result.add(Arrays.asList(lower, nums[0]-1));
        }
        
        //2. nums[i] - 1 != nums[i-1] -> [nums[i-1]+1, nums[i] - 1]
        for(int i=1; i< len; i++){
            if(nums[i] - 1 != nums[i-1]){
                result.add(Arrays.asList(nums[i-1]+1,  nums[i]-1));
            }
        }
        
        //3. nums[len-1] < upper
        if(nums[len-1] < upper){
            result.add(Arrays.asList(nums[len-1]+1,  upper));
        }
        
        return result;
        
    }
    
    /*Mistakes:
    Implementing case 1 and 3 inside the loop made it little weird though possible for simplicity it's better to do operations on 0th and nth element outside of the loop if possible*/
    
}