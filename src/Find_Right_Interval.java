import util.Interval;

import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by Alvin on 16/12/6.
 */
public class Find_Right_Interval {
    public int[] findRightInterval(Interval[] intervals) {
        int[] result = new int[intervals.length];
        NavigableMap<Integer , Integer> map = new TreeMap<>();
        for (int i =0 ;i < intervals.length;i++){
            map.put(intervals[i].start,i);
        }
        for (int i=0; i < intervals.length;i++){
            Map.Entry<Integer, Integer> entry = map.ceilingEntry(intervals[i].end);
            result[i] = entry ==null ? -1 : entry.getValue();
        }
        return result;
    }

    public static void main(String[] args) {
        //[1,4], [2,3], [3,4]
        Interval[]  intervals = {new Interval(1,4),new Interval(2,3),new Interval(3,4)};
        System.out.println(Arrays.toString(new Find_Right_Interval().findRightInterval(intervals)));
    }

    // http://blog.csdn.net/jackyrongvip/article/details/9218803
    // 使用NavigableMap
}
