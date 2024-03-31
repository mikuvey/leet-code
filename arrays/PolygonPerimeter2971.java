import java.util.Arrays;

class Solution {
    public long largestPerimeter(int[] nums) {
        //Sort array
        Arrays.sort(nums);

        //Sum + Best case
        long perimeter = -1;
        long sum = 0;

        for(int i=0; i< nums.length; i++){
            if( i > 1 && sum > nums[i]){
                perimeter  = sum + nums[i];
            }

            sum += nums[i];
        }

         return perimeter;
    }
}