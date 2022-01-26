public class WordSearch {
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        for(int r=0;r<board.length;r++){
            for(int c=0;c<board[r].length;c++){
                boolean ans = isWordExist(board,r,c,0,word);
                if(ans) return true;
            }
        }
        
        return false;
    }
    
    static boolean isWordExist(char[][] board,int r,int c,int index,String word){
        if(index==word.length() ){
            return true;
        }else if(r<0||c<0||r==board.length||c==board[r].length||word.charAt(index)=='@'){
            return false;
        }
        
        char ch = word.charAt(index);
        if(board[r][c]!=ch) return false;
        board[r][c]='@';
        
        boolean ans = isWordExist(board,r+1,c,index+1,word);
        if(ans) return true;
        ans = isWordExist(board,r-1,c,index+1,word);
        if(ans) return true;
        ans = isWordExist(board,r,c+1,index+1,word);
        if(ans) return true;
        ans = isWordExist(board,r,c-1,index+1,word);
        if(ans) return true;
        
        board[r][c]=ch;
        
        return false;
    }
}
