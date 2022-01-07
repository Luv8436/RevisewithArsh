import java.util.*;
public class isValidSudoku {
    static int isValid(int board[][]){
        // code here
        for(int row=0;row<9;row++){
            int sr=(row/3)*3;
            int sc=(row%3)*3;
            HashSet<Integer> rowSet = new HashSet<>();
            HashSet<Integer> colSet = new HashSet<>();
            HashSet<Integer> squareSet = new HashSet<>();
            for(int col=0;col<9;col++){
                int r = sr+(col/3);
                int c = sc+(col%3);
                if(board[row][col]!=0){
                    if(rowSet.contains(board[row][col])){
                        return 0;
                    }else{
                        rowSet.add(board[row][col] );
                    }
                }
                
                if(board[col][row]!=0){
                    if(colSet.contains(board[col][row])){
                        return 0;
                    }else{
                        colSet.add(board[col][row] );
                    }
                }
                
                if(board[r][c]!=0){
                    if(squareSet.contains(board[r][c])){
                        return 0;
                    }else{
                        squareSet.add(board[r][c] );
                    }
                }
                
            }
        }
        
        return 1;
    }
}
