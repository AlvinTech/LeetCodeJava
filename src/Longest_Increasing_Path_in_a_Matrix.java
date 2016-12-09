/**
 * Created by Alvin on 16/12/9.
 */
public class Longest_Increasing_Path_in_a_Matrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length==0)
            return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][]  cahe = new int[n][m];
        int max = Integer.MIN_VALUE;
        for (int i =0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                max = Math.max(max,maxLen(matrix,i,j,cahe,Integer.MIN_VALUE));
            }
        }

        for (int i =0; i < n; i++){
            for (int j = 0 ; j < m; j++){
                max = Math.max(max,cahe[i][j]);
            }
        }
        return max;
    }

    private int maxLen(int[][] matrix , int i , int j , int[][] cache, int min){
        int n = matrix.length, m = matrix[0].length;
        if(i < 0 || i >= n)
            return 0;
        if(j < 0 || j >= m)
            return 0;
        if(matrix[i][j] <= min){
            return 0;
        }
        if(cache[i][j] != 0){
            return  cache[i][j];
        }

        int leftLen = maxLen(matrix,i-1,j, cache,matrix[i][j]) + 1;
        int rightLen = maxLen(matrix,i+1,j, cache,matrix[i][j])+ 1;
        int upLen = maxLen(matrix,i,j-1, cache,matrix[i][j])+ 1;
        int downLen = maxLen(matrix,i,j+1, cache,matrix[i][j])+ 1;
        cache[i][j] = Math.max(leftLen, Math.max(rightLen,Math.max(upLen,downLen)));
        return cache[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(new Longest_Increasing_Path_in_a_Matrix().longestIncreasingPath(matrix));
    }
}
