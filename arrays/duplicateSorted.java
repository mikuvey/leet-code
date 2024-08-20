//Non Optimized nLogn solution
class Solution {
    public int removeDuplicates(int[] nums) {
        /**
        dic = {1:2, }
        (If dic(elem) is greater than 2) -> Write with the last element and add that element to
        [1,1,2,2,3,3,3,3,3,3]
                     r
                           w
        
        Loop end condition -> Either is when the read pointer either reaches end of array of next
        element is -1
        edge -> When read and write pointers coincide and the element should be either left is as 
        it is or will be 0
         */

        Map<Integer, Integer> map = new HashMap<>();
        
        int reader = 0;
        int writer = nums.length -1;

        while(reader < nums.length && nums[reader] != Integer.MAX_VALUE ){
            //Update map
            int val = map.getOrDefault(nums[reader], 0) + 1;
            map.put(nums[reader], val);

            if(map.get(nums[reader]) < 3){
                reader++;
            }
            else{
                map.put(nums[reader], 2);
                nums[reader] = nums[writer];
                nums[writer] = Integer.MAX_VALUE;
                writer --;
            }
        }
        //System.out.println(reader);
        Arrays.sort(nums);
        //nlogn -> Solution
        return reader;
    }
}