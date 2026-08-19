public class Bit {

    //2220. Minimum Bit Flips to Convert Number
    public int minBitFlips(int start, int goal) {
        int ans = start^goal;

        int minBitFlip=0;
        while(ans>1){
            minBitFlip += ans & 1;
            ans = ans >> 1;
        }
        if(ans==1)minBitFlip+=1;

        return minBitFlip;
    }





    public static void main(String[] args) {

    }
}