class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        #Challenge: O(1) space time; Cause with the usage of map could have solved it
        #Using Boyre - Moores Algorithm:
        """
        The majority element is the one with more than 50% of size of the array (Using this clue let's degin our algorithm)
        Consider the first element as a majority and increment when encounterd again decrement when different element is encontered. 
        When the count becomes 0; Change the majority element to current element;
        After all the iterations(by end of the array) we will be left with the original majority element as the other elements are less than 50%
        """
        count = 0
        major = nums[0]
        
        for i in range(len(nums)):
            if nums[i] == major:
                count += 1
            else:
                count -= 1
            
            if count == 0:
                major = nums[i]
                count += 1
        
        return major
                
                
        