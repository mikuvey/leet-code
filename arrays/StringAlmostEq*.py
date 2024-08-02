class Solution:
    def checkAlmostEquivalent(self, word1: str, word2: str) -> bool:
        counter = [0] * 26

        #Itereate with len(word1) as length is same for both
        for i in range(len(word1)):
            # Increment if character i found in word1 and viceversa
            counter[ord(word1[i]) - ord('a')] += 1
            counter[ord(word2[i]) - ord('a')] -= 1
        
        #Iterate to check if any element is greater than 3
        for i in range(len(counter)):
            if abs(counter[i]) > 3:
                return False
        return True