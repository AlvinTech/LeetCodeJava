import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alvin on 16/12/24.
 */
public class Binary_Watch {
    public List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<>();
        for (int i =0; i < 12;i++ ){
            int hours = bits(i);
            for (int j = 0; j < 60; j++){
                int mins = bits(j);
                if(hours + mins == num){
                    if(j < 10){
                        list.add(i+":0"+j);
                    }else{
                        list.add(i+":"+j);
                    }
                }
            }
        }
        return  list;
    }

    private static int bits(int value){
        int count = 0;
        while(value != 0){
            count += value & 1;
            value = value >>1;
        }
        return count;
    }


    public static void main(String[] args) {
        int num = 1;
        System.out.println(new Binary_Watch().readBinaryWatch(1));
        System.out.println(Integer.toBinaryString(num)+ " "+ bits(num));
    }
}
