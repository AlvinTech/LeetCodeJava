/**
 * Created by pengli on 11/15/2016.
 */
public class Battleships {
    public int countBattleships(char[][] board) {
        int result = 0;
        int rows = board.length;
        int columns = board[board.length-1].length;

        for(int i = 0 ;i < rows ; i++)
            for (int j =0 ; j < columns; j++){
                if( (board[i][j] == 'X') && ((i ==0 && j== 0) || (i ==0  && j !=0 && board[i][j-1] != 'X') || (i !=0 && j==0 && board[i-1][j]!='X') || (i!=0 && j != 00 && board[i-1][j]!='X' && board[i][j-1]!='X'))){
                    result++;
                }
            }
        return result;
    }

    public static void main(String[] args) {
        char[][] board ={{'X','X','X','X',}};
        System.out.println(new Battleships().countBattleships(board));
    }
}
