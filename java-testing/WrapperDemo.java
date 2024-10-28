public class WrapperDemo{

    public static void main(String[] args){
        int a = 10;
        int b = 12;

        //Auto Boxing
        Integer c = a;
        Integer d = b;

        // Value Of method
        Integer ten = Integer.valueOf("10");
        Integer three = Integer.parseInt("3");
        Integer binToDecNum = Integer.parseInt("10101010", 2 );
    }
}