from collections import deque

class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        #Algorithm
        """
        Iterate over the list, when op is found -> Get last two elements and do the operation and insert the result back in the op index; Perform the same for entire the array/list
        """
        #DS -> Using the stack is the most intutive way of solving this problem
        
        stack = deque()
        result = int(tokens[0])
        
        for i in range(len(tokens)):
            
            if tokens[i] == "+":
                b = stack.pop()
                a = stack.pop()
                result = int(a) + int(b)
                stack.append(result)
            elif tokens[i] == "-":
                b = stack.pop()
                a = stack.pop()
                result = int(a) - int(b)
                stack.append(result)
            elif tokens[i] == "*":
                b = stack.pop()
                a = stack.pop()
                result = int(a) * int(b)
                stack.append(result)
            elif tokens[i] == "/":
                b = stack.pop()
                a = stack.pop()
                result = int(int(a)/int(b))
                stack.append(result)
            else:
                stack.append(tokens[i])
        
        return result