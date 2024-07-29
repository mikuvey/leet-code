class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        mapStrs = {}
        slow = 0
        res = 0
        
        for fast in range(len(s)):
            if s[fast] in mapStrs and mapStrs[s[fast]] >= slow:
                slow = mapStrs[s[fast]] + 1
                
            mapStrs[s[fast]] = fast
            res = max(res, fast - slow + 1)
            
        return res
