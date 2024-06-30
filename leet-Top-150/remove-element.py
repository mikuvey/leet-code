class Solution:
    def removeElement(self, nums: List[int], val: int) -> int:
        #In Place
        #Logic: If current element is "val", replace with an len(nums) - n element
        #ptrs: Forward pointer; backward pointer to track val replacement
        #vars: Counter to count number of vals
        #k = len(nums) - count(val)

        #Algorithm: Iterate through nums; 
        #if nums[i] == val (swap with) nums[m] (if it's not equal to val) m--
        #                                       else while(nums[m] m--)
        
        #[3,2,2,3]
        m = len(nums) - 1  #m = 3
        i = 0
        count = 0

        while i < m:#0 < 3
            if nums[i] == val: #true
                while m>0 and nums[m] == val:
                    nums[m] = 0 
                    m -= 1 

                #m = 2
                #exception: If all the values are val
                if m == 0:
                    break
                #swap 
                # tmp = nums[i]
                # nums[i] = nums[m]
                # nums[m] = tmp
                nums[i] = nums[m]
                nums[m] = 0
                #val Count
                count += 1
            i += 1
        
        k = len(nums) - count

        print(k)
        print(nums)
        return k