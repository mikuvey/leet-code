class Amazon1 {

    public int getMaxExection(int[] time, int m, int k){
        /* */
        //1st Pass?
        int totalTime = m*k;
        int timeSum = 0;
        boolean executed = true;
        int maxExecuted = 0;
        int afterCheck = 0;

        for(int i=0; i<time.length; i++){
            timeSum += time[i];
            maxExecuted++;
            if(timeSum >= totalTime){
                executed = false;
                break;
            } 
        }

        if(!executed){
            int i=1;
            afterCheck = maxCheck(time, totalTime, timeSum);
        }

        return Math.max(maxExecuted, afterCheck);
    }

    public int maxCheck(int time[], int totalTime, int timeSum){
        for(int i= 0; i<time.length; i++){
            if(totalTime >= timeSum){
                return time.length - i;
            }
            timeSum -= time[i];
        }
        return 0;
    }
    public static void main(String[] args) {
        System.out.println("Hello, Amazon1");
        int[] time = {5, 2, 1, 4, 2};
        int m = 2;
        int k = 6;
        System.out.println(getMaxExection(time, m, k))
    }
}