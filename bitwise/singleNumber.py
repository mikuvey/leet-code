class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        a = 0
        
        for i in nums:
            a = a ^ i
        
        return a

#link: https://www.youtube.com/watch?v=qMPX1AOa83k
# THe main idea of this solution is that by performing XOR operation on each
#element of the array we are going to end up on that unique element as the remainig
#elemts are going be cancelled out eventually as we iterate through the array
        