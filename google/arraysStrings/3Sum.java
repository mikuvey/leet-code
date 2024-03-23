class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //Important logic or hint for this problem is to sort to eliminate duplicates
        //Whenever we encounter such situation to elimintate duplicates in an integer array we could
        //opt for sorting.
        //And then use 2ptrs for two sum if array is sorted else we could go for hashmap 2 sum
        
        //result list
        List<List<Integer>> result = new ArrayList<>();
        
        //Sort
        Arrays.sort(nums);
        
        for(int i=0; i< nums.length - 2; i++){
            int left = i + 1;
            int right = nums.length - 1;
            int target = nums[i];
            
            //Stops duplication
            if(i > 0 && target == nums[i-1]){ 
                continue;
            }
            
            //2Sum
            while(right > left){
                
                //Check if -(left + right) = Target
                int sum = -(nums[left] + nums[right]);
                
                //C11: When target = sum
                if(target == sum){    //
                    List<Integer> ls = new ArrayList<>();
                    ls.add(target);
                    ls.add(nums[left]);
                    ls.add(nums[right]);
                    
                    result.add(ls);   
                    left++;
                    right--;
                    
                    //Important piece of code I have struggled here as I faced edge cases
                    //While loop to eliminate duplicates
                    while(left < right && nums[left] == nums[left - 1]){
                        left++;
                    }
                }
                //C2: When target > sum
                else if(target > sum){
                    right--;
                }
                //C3: when target < sum
                else{
                    left++;
                }
                
            }
        }
        
        return result;
    }
}