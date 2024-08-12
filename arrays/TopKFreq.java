import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFreq {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer a, Integer b){
                return Integer.compare(count.get(b), count.get(a));
            }
        });

        //Get the freqs of all the elements in the array
        for(int i = 0; i<nums.length; i++){
            int val = count.getOrDefault(nums[i], 0)+1;
            count.put(nums[i], val);
        }
        // System.out.println(count);

        for(int i :count.keySet()){
            pq.offer(i);
        }
        // System.out.println(pq);

        List<Integer> result = new ArrayList<>();
        for(int i=0; i<k; i++){
            result.add(pq.poll());
        }

        //Result list to array
        int[] res = new int[result.size()];
        for(int i=0; i<res.length; i++){
            res[i] = result.get(i);
        }

        return res;
    }
}
