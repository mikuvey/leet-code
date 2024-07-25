from collections import defaultdict

class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        andic = defaultdict(list)
        
        for s in strs:
            idList = [0]*26
            
            for c in s:
                idList[ord(c) - ord('a')] += 1
            
            andic[tuple(idList)].append(s)
        
        return andic.values()
        
        