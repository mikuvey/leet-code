class Solution:
    def checkAlmostEquivalent(self, word1: str, word2: str) -> bool:
        #{a:1, b: 1., c:1, d:1, e:2, f:1}, {a:4, b:1,c:2}
        dic1 = {}
        dic2 = {}

        for i in range(len(word1)):
            s = word1[i]
            if s in dic1:
                dic1[s] += 1
            else:
                dic1[s] = 1
        
        for i in range(len(word2)):
            s = word2[i]
            if s in dic2:
                dic2[s] += 1
            else:
                dic2[s] = 1
        
        #Compare maps
        #Challenge (comparing non existant keys) -> Could be solved with condition
        #Challenge is looping through which dictionary (based on max length? -> Results in redundant code)

        #Two pass
        for i in dic1.keys():
            if i in dic2:
                #seen.append(i) //add(i)?
                sub = abs(dic1[i] - dic2[i])
                if sub > 3:
                    return False
            else:
                if dic1[i] > 3:
                    return False

        for i in dic2.keys():
            if i in dic1:
                continue
            else:
                if dic2[i] > 3:
                    return False
        return True
            
        