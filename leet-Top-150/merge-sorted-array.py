class Solution:
    def merge(self, nums1: List[int], m: int, nums2: List[int], n: int) -> None:
        """
        Do not return anything, modify nums1 in-place instead.
        """
        #nums1 (m+n); nums2(n);
        #Merge nums2 into nums1 (while the result should be in increasing order)
        #How: Comparing (with two pointers) the smallest will be stayed(if nums1) or inserted (nums2)
        #edge: return nums1 if len of nums2 is 0
        #check/Q's: does insert method work in lists? Insertion increase the length of the list too
        #Q's: How would have I done in java?
        
        #1st attempt: error after 39/51 test cases (case: nums1: [-1,0,0,3,3,3,0,0,0])
        # i = 0
        # j = 0
        # nums1_len = len(nums1)

        # while i < nums1_len: # 3 < 6
        #     #check
        #     if j < len(nums2) and (nums1[i] > nums2[j] or nums1[i] == 0): # 3 > 2
        #         nums1.insert(i, nums2[j]) 
        #         j += 1 #j=1
        #         i += 1 #i=3
        #     else:
        #         i += 1 #i = 2
            
        # del nums1[i: len(nums1)]
        
        #Attempt 2:
        #Algorithm: Three pointers (starting from the end)
        k = m + n - 1 #1
        m = m - 1 #0
        n = n - 1 #0

        while k >= 0: #1>=0
            if n < 0: #0 < 0:
                break
            elif m>= 0 and nums1[m] > nums2[n]: #1>2
                nums1[k] = nums1[m] # [1] = [0]
                nums1[m] = 0 #[0] = 0
                k -= 1 #1
                m -= 1 #1
            else:
                nums1[k] = nums2[n]
                k -= 1 #1
                n -= 1 #-1
                


        #Feedback: I totally struggled to judge various test cases and edge cases and write the code 
                #accordingly, that's y I couldn't write an efficient code for a long time.