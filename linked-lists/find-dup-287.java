class Solution {
    public int findDuplicate(int[] nums) {
        //Using the Floyds slow and fast pointers
        //This array is deceptively a Linked List i.e. we have to assume every number points to it's index in array
        //It's better to go check neetCode video if you don't understand

        /**
         */

         int slow = 0;
         int fast = 0;
 
         while(true){
             slow = nums[slow];
             fast = nums[nums[fast]];
 
             if(slow == fast){
                 break;
             }
         }
 
         slow = 0;
 
         while(true){
             slow = nums[slow];
             fast = nums[fast];
 
             if(slow == fast){
                 break;
             }
         }
 
         return slow;
        
        // //Using the sum of n numbers
        // /**i.e.
        // 1. Find length of array -> n+1
        // 2. Find the sum of all elements in array
        // 3. Now repeat = sum of elem - sum of n natural numbers n(n+1)/2
        // Problem with the approach: The repeat num could repeat n+1
        // Failed test case: [2,2,2,2,2]*/

        // int len = nums.length;
        // int sumArr = 0;

        // //sum of all elements in array
        // for(int i=0; i<len; i++){
        //     sumArr += nums[i];
        // }

        // System.out.println(sumArr);

        // //Sum of natural nums
        // int n = len - 1;
        // int sum = n*(n+1)/2;

        // System.out.println(sum);
        // //result
        // int repeat = sumArr - sum;

        // return repeat;
    }
}