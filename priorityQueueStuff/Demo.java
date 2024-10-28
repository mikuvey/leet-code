import java.util.*;

public class Demo {
    // A method that accepts an n*m matrix
    public int yGame(int[][] matrix){
        // Return the number of changes to make Y elements the same and non-Y elements the same
        int result = 0;
        
        List<List<Integer>> res = getYelements(matrix);
        List<Integer> yelems = res.get(0);
        List<Integer> notYelems = res.get(1);

        result += yelems.size() - getFreq(yelems);
        result += notYelems.size() - getFreq(notYelems);

        return result;
    }

    // Method to get the maximum frequency of elements in a list
    public int getFreq(List<Integer> elements){
        Map<Integer, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for(int num : elements){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(num));
        }
        return maxFreq;
    }

    // Get all the elements in the coordinates that make Y in a matrix
    public List<List<Integer>> getYelements(int[][] matrix){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> yelements = new ArrayList<>();
        List<Integer> notYelements = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == j || i + j == n - 1){
                    yelements.add(matrix[i][j]);
                }
                else{
                    notYelements.add(matrix[i][j]);
                }
            }
        }

        result.add(yelements);
        result.add(notYelements);

        return result;
    }

    public static void main(String[] args){
        Demo demo = new Demo();
        int[][] matrix = {
            {1, 2, 1},
            {3, 1, 4},
            {1, 5, 1}
        };
        System.out.println(demo.yGame(matrix));
    }
}
