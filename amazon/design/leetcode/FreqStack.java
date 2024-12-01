package amazon.design.leetcode;

class FreqStack {
    private Map<Integer, Integer> counter;
    private Map<Integer, Stack<Integer>> mapStack;
    private int max;
    
    public FreqStack() {
        /*
        Pop most freq element from stack;
        Note: Frequency is based on the number of occurences of a number at that given time of the             stack.
        Pop contition: most freq. If freq are equal pop the one on top;
        
        5,7,5,7,4,5
        max = 2
        {5:2, 7:2, 4:1}   {1:[5,7,4], 2:[5,7], 3:[5]}
        
        5-7-5-7-4
        
        -> We need a flexible stack: What I mean by that, I should have the ability to go any given level of the stack.
        -> In O(1), I should know the most freq element.
        
        Bruteforce: O(1) by comparision
         */
        
        this.counter = new HashMap<>();
        this.mapStack = new HashMap<>();
        this.max = 0;
    }
    
    public void push(int val) {
        //Update the counter
        counter.put(val, counter.getOrDefault(val, 0) + 1);
        
        //Push the value to it's slot based on it's frequency
        int freq = counter.get(val);
        
        //Initialize the stack and update max
        if(max < freq){
            max = freq;
            mapStack.put(max, new Stack<>());
        }
        
        //Update the current stack
        Stack<Integer> stk = mapStack.get(freq);
        stk.push(val); //Push done
    }
    
    public int pop() {
        int ret = -1;
        
        //Pop element from max Stack
        Stack<Integer> stk = mapStack.get(max);
        ret = stk.pop();
        
        //If a stack is empty update the max variable (let's do this check after every operation)
        if(stk.isEmpty()){
            //Remove the level in mapStack
            mapStack.remove(max); 
            max--;
        }
        
        //Update the counter
        counter.put(ret, counter.get(ret)-1);
        if(counter.get(ret)<1){
            counter.remove(ret);
        }
        
        return ret;
    }
    
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 * 
 * Test:
 * FreqStack freqStack = new FreqStack();
freqStack.push(5); // The stack is [5]
freqStack.push(7); // The stack is [5,7]
freqStack.push(5); // The stack is [5,7,5]
freqStack.push(7); // The stack is [5,7,5,7]
freqStack.push(4); // The stack is [5,7,5,7,4]
freqStack.push(5); // The stack is [5,7,5,7,4,5]
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

 */
