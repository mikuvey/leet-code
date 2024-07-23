class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        #Algorithm
        """
        Wrong Implementation: Iterate over the list, when op is found -> Get last two elements and do the operation and insert the result back in the op index; Perform the same for entire the array/list
        """
        #DS required -> Nothing; I believe we could manage it using a switch cases
        for i in range(len(tokens)):
            if tokens[i] == "+":
                tokens[i] = tokens[i-2] + tokens[i - 1]
                tokens.pop(i-2)
                tokens.pop(i-1)
            elif tokens[i] == "-":
                tokens[i] = tokens[i-2] - tokens[i - 1]
                tokens.pop(i-2)
                tokens.pop(i-1)
            elif tokens[i] == "/":
                tokens[i] = int(tokens[i-2] / tokens[i - 1])
                tokens.pop(i-2)
                tokens.pop(i-1)
            elif tokens[i] == "*":
                tokens[i] = tokens[i-2] * tokens[i - 1]
                tokens.pop(i-2)
                tokens.pop(i-1)
            else:
                continue
        
        return tokens[0]
            