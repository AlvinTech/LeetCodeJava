/**
 * Created by Alvin on 16/11/28.
 */
public class Reverse_Bits {
    
    public int reverseBits(int n) {
        int result = 0;
        for (int i =0 ; i< 32; i++){
            result = result * 2 + (n & 1);
            n = n >> 1;
        }
        return  result;
    }


    public static void main(String[] args) {
      System.out.println(new Reverse_Bits().reverseBits(43261596));
    }
}
