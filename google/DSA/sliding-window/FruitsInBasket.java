class Solution {
    public int totalFruit(int[] fruits) {
        //Using SLiding Window
        //One of the important aspect of SW to use is a constraint that would limit the incrementing j and gives i an oppurtunity to move further
        //In this algorithm the limiting logic is number of different trees that j comes across starting from i
        //if it's more than 2 that's it we stop j and move i a bit further
        
        int back = 0;
        int front = 0;
        int max_trees = 0;
        
        Map<Integer, Integer> bag = new HashMap<>();
        
        while(front < fruits.length){
            //C1: When bag size is less than or equal to 2
            if(bag.size() <= 2){
                int val = bag.getOrDefault(fruits[front], 0);
                val++;
                bag.put(fruits[front], val);
                front++;
            }
            //C2: When bag size is greater than 2
            //C3: When front is at the end and back inc to check other cases
            else{
                int curr = bag.get(fruits[back]);
                if( curr <= 1) bag.remove(fruits[back]);
                else{
                    curr--;
                    bag.put(fruits[back], curr);
                }
                back++;
            }
            
            if(bag.size() <= 2){
                max_trees = Math.max(max_trees, front - back);  
            }
            
        }
        
        return max_trees;
    }
}