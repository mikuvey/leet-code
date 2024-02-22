import java.util.HashMap;
import java.util.HashSet;

class TownJudge997 {
    public int findJudge(int n, int[][] trust) {
        //Using HashMap(num, num) find the freq of each 2nd element of sub array
        // For loop of keys: 
        //if freq of a given key is equals to length of array then true; break;
        //else ret -1;

        //edge
        if(n == 1){
            return 1;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int i=0; i<trust.length; i++){
            set.add(trust[i][0]);
            int k = map.getOrDefault(trust[i][1], 0);
            k += 1;
            map.put(trust[i][1], k);
        }

        for(int i : map.keySet()){
            if(map.get(i) == n-1 && !set.contains(i))
                return i;
        }

        return -1;
    }
}