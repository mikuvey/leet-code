class KthLargest {
    private int k;
    private Queue<Integer> pq;

    public KthLargest(int k, int[] nums) {
        //INITIALIZATION
        this.k = k;
        this.pq = new PriorityQueue<>();

        for(int i: nums){
            add(i);
        }
    }
    
    public int add(int val) {
        /**
        k = 3 nums = [4,5,8,2]
        add(3)
        [4, 5, 8, 2, 3] -> 4
        [4, 5,5,8,2,3, 10, 4] -> 8

        DS: Heap (Priority Queue): [10, 9, 8, 5, 5, 4, 3, 2] -> Poll till kth element(n)
        + Then add all the elements back (n)
         */

        //Operation: Appends val to the stream
        //Append
        if(pq.size() < k){
            pq.offer(val);
        }
        else if(pq.peek() < val){
            pq.poll();
            pq.offer(val);
        }
        //Out: kth largest element
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */