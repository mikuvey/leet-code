class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        
        #State Variable:How much is my loot by the end of all the houses
        # An ith element in dp[] should store the maximum Loot till and including that house
        #Recurence Relationship: dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        

        #Bottom Up
        
        numLength = len(nums)
        
        if numLength == 1:
            return nums[0]
        
        dp = [0]*numLength
        
        dp[0] = nums[0]
        dp[1] = max(nums[0], nums[1])
        
        for i in range(2, numLength):
            dp[i] = max(dp[i-1], nums[i] + dp[i-2])
        
        print(dp)
        return dp[-1]

solution = Solution()

print(solution.rob([2,7,9,2,1]))