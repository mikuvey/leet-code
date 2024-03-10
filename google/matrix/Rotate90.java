//https://leetcode.com/problems/rotate-image/
class Solution {
    public void rotate(int[][] matrix) {
        //M(Rotate) = (M(Transpose) -> M(Reflect/Reverse))
        
        Transpose(matrix);
        Reflect(matrix);
    }

    public void Transpose(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }

    public void Reflect(int[][] matrix){
        int n = matrix.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }
    }

}