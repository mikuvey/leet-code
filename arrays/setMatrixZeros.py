class Solution:
    def setZeroes(self, matrix: List[List[int]]) -> None:
        """
        Do not return anything, modify matrix in-place instead.
        """
        #While we are replacing elements with zero, it's important to establish the boundaries properly
        #Trigger through Iteration O(n)
        #Call replace with zeros function
            #Internally we got to have 2 loops:
            #1. row = 0 to n-1, with col(const): and don't mark visited if it's already a 0
            #2. col = 0 to n-1, with row(const): make sure to track
        #Challenge: Keeping track of visited elements; If element is visited and 0->Ignore it don'tCall
        
        #Search for zeros
        visited = set()
        for row in range(len(matrix)):
            for col in range(len(matrix[0])):
                if matrix[row][col] == 0 and (row,col) not in visited:
                    self.replaceWithZeros(row, col, matrix, visited)
    
    def replaceWithZeros(self, row, col, matrix, visited):
        #Replace row
        for r in range(len(matrix)):
            if matrix[r][col] == 0:
                continue
            matrix[r][col] = 0
            visited.add((r, col))
        
        #Replace col
        for c in range(len(matrix[0])):
            if matrix[row][c] == 0:
                continue
            matrix[row][c] = 0
            visited.add((row, c))
            
        