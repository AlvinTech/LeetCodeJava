import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alvin on 16/11/12.
 */
/*
Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).

Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).

Example:
Input:
[[0,0],[1,0],[2,0]]

Output:
2

Explanation:
The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]



 */

public class Number_of_Boomerangs {
    public int numberOfBoomerangs(int[][] points) {
        int size = points.length;
        if(size < 3)
            return 0;

        int result = 0;
        for (int i = 0 ; i < size; i++){
            Map<Long,Integer> map = new HashMap<>();
            for (int j= 0; j < size;j++){
                int ix = points[i][0];
                int iy = points[i][1];
                int jx = points[j][0];
                int jy = points[j][1];
                long value = (jx-ix) * (jx - ix) + (jy-iy) * (jy-iy);
                if(map.get(value)==null){
                    map.put(value,1);
                }else{
                    map.put(value,map.get(value)+1);
                }
            }
            for(long key : map.keySet()){
                int count = map.get(key);
                if(count >1){
                    result += count* (count-1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points ={{0,0},{1,0},{2,0}};
        System.out.println(new Number_of_Boomerangs().numberOfBoomerangs(points));
    }
}
