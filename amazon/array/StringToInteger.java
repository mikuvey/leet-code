package array;

public class StringToInteger {
    public int myAtoi(String s) {
        /*
        "" -> 0
        0-1 -> -1
        0+1 -> 1
        2+3 -> 2
        -043 -> 43 (+ve tpp)
        w5 -> 0
        123-4 -> 123
        -0000043
        */
        
        int num = 0;
        StringBuilder sb = new StringBuilder();
        
        //Trim
        String str = s.trim();
        int size = str.length();
        
        //Edge
        if(size==0){
            return 0;
        }
        
        
        //Iterate
        for(int i=0; i<size; i++){
            char c = s.charAt(i);
            
            //Handle -, + -43 -> 43
            if((sb.length() == 0) && (c == '-' || c == '+')){
                sb.append(c);
                continue;
            }
            
            //Handle non number; -, +(Only before number starts is true) 
            else if(!(c >= '0' && c<= '9')){
                break;
            }
            
            //Handle nums bigger than 32 bit (round up)
            
            
            //Handle general case
            else{
                sb.append(c);
            }
        }
        
        System.out.println(sb);
        if(sb.length() > 0)
            num = Integer.parseInt(sb.toString());
        return num;
    }
    
}
