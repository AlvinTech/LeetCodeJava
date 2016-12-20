/**
 * Created by Alvin on 16/12/20.
 */
public class Hamming_Distance {
    public int hammingDistance(int x, int y) {
        int value = x ^ y;
        int count =0;
        while(value != 0 ){
            count += value & 1;
            value = value >> 1;
        }
        return  count;
    }

    public static void main(String[] args) {
        System.out.println(new Hamming_Distance().hammingDistance(1,8));
    }
}
