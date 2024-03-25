class Solution {
    public int maxArea(int[] height) {
        //We could use two pointers to solve this
        //Moving point: The smallest height one always moves
        //In two pntrs generally the length of the array also matters
        
        int left = 0;
        int right = height.length - 1;
        int max_water = 0;
        
        while(right > left){
            int small = Math.min(height[left], height[right]);
            int Area = small * (right - left); //Eg: 7 * 8-1 = 49
            
            max_water = Math.max(max_water, Area); 
            
            if(height[left] < height[right]){
                left++;
            }
            else{
                right--;
            }
        }
        
        return max_water;
    }
}