/**
 * Created by Alvin on 16/11/26.
 */

/*
Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
* */
public class Rectangle_Area {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int aera1 = (C-A) * (D-B);
        int aera2 = (G-E) * (H-F);
        int x = dis(A,C,E,G);
        int y = dis(B,D,F,H);
        int aera3 = y * x;
        return  aera1 + aera2 -aera3;
    }
    private int dis(int start ,int end , int x1 , int x2){
        // start < end   x1 < x2  计算在坐标轴上的相对投影
        long min = Math.min(start, x1);
        long max = Math.max(end, x2);
        long dis = (max- min) -(end -start) -(x2 -x1);
        return dis > 0 ? 0 : (int)-dis;
    }
    public static void main(String[] args) {
        System.out.println(new Rectangle_Area().computeArea(-1500000001,0,-1500000000,1,
                1500000000,0, 1500000001,1));
    }
}
