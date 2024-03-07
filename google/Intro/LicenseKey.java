class Solution {
    public String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int count = s.length() - 1;
        int kCount = 0;
        
        while(count >= 0){
            char curr = s.charAt(count);
            //When curr is -
            if(curr == '-'){
                count--;
                continue;
            }
            
            //When kcount = k
            if(kCount == k){
                sb.append('-');
                kCount = 0;
                continue;
            }
            
            //When curr is lowerCase
            if(Character.isLowerCase(curr)){
                curr = Character.toUpperCase(curr);
            }
            
            sb.append(curr);
            count--;
            kCount++;
        }
        
        //Reverse the string
        StringBuilder str = sb.reverse();
        
        return str.toString();
    }
}