class rearrangeArray2197 {
    public int[] rearrangeArray(int[] nums) {
        //Brute: Collect pArr, nArr -> Merge them alternatively -> O(2n) (Two pass)

        //Intit
        // int len = nums.length;

        // int[] pArr = new int[len/2];
        // int[] nArr = new int[len/2];
        // int[] result = new int[len];

        // int j = 0;
        // int k = 0;

        // //Split Nums based on sign
        // for(int i=0; i<len; i++){
        //     if(nums[i] > 0){
        //         pArr[j] = nums[i];
        //         j++;
        //     }
        //     else{
        //         nArr[k] = nums[i];
        //         k++;
        //     }   
        // }

        // //Merge Alternatively
        // j = 0;
        // k = 0;
        // for(int i=0; i<len; i++){
        //     if(i%2 == 0){
        //         result[i] = pArr[j];
        //         j++;
        //     }
        //     else{
        //         result[i] = nArr[k];
        //         k++;
        //     }
        // }
        // return result;

        //Optimised in One Pass, two pointers
        int len = nums.length;
        int[] result = new int[len];
        int pPtr = 0;
        int nPtr = 1;

        /**Logic -> All positives should be in even position, viceversa
        Using ptrs for respective numbers */
        for(int i=0; i<len; i++){
            if(nums[i] > 0){
                result[pPtr] = nums[i];
                pPtr+= 2;
            }
            else{
                result[nPtr] = nums[i];
                nPtr+= 2;
            }
        }

        return result;
    }
}