package ctci.chapter5;

public class FlipBitToWin {

    public static int getlongestLen1s(int n){
        int maxLen = 0;
        int zeroMark = -1;
        int len = 0;
        int i = 0;
        while(n > 0){
            if( (n & 1) == 1){//most right digit is 1
                len++;
                maxLen = Math.max(len, maxLen);
            }else {
                if(zeroMark < 0){
                   len++;
                }else{
                   len -= zeroMark;
                   len--;
                }
                zeroMark = i;
            }
            i++;
            n = n >>> 1;
        }
       return maxLen;
    }

    public static void main(String[] args) {
System.out.printf("max len = %d \n", FlipBitToWin.getlongestLen1s(1775));


    }



}
