/**
 * Created by Alvin on 16/11/20.
 */

/**

 You are given a map in form of a two-dimensional integer grid where 1 represents
 land and 0 represents water. Grid cells are connected horizontally/vertically (not diagonally).
 The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected
 land cells). The island doesn't have "lakes" (water inside that isn't connected to the water around the
 island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 Determine the perimeter of the island.

 Example:

 [[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
 *
 */

public class Island_Perimeter {
    public int islandPerimeter(int[][] grid) {
        int length = 0 ;
        for (int i =0 ; i< grid.length; i++)
            for (int j =0 ; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if((i == 0) || (grid[i-1][j] != 1)){
                        length++;
                    }

                    if(i == grid.length-1 || grid[i+1][j] != 1){
                        length++;
                    }

                    if((j == 0) || (grid[i][j-1] != 1)){
                        length++;
                    }

                    if(j == grid[0].length-1 || grid[i][j+1] != 1){
                        length++;
                    }
                }
            }
        return length;
    }

    public static void main(String[] args) {
        //int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        int[][] grid = {{1},{0}};
        System.out.println(new Island_Perimeter().islandPerimeter(grid));
    }
}
