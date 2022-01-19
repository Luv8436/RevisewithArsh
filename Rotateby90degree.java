public class Rotateby90degree {
    static void rotate(int matrix[][]) 
    {
        // Code Here
        int n = matrix.length;
        // reverse cols
        for(int row=0;row<n;row++){
            int lc = 0;
            int rc = n-1;
            while(lc<rc){
                int temp = matrix[row][lc];
                matrix[row][lc]=matrix[row][rc];
                matrix[row][rc]=temp;
                lc++;
                rc--;
            }
        }
        
        // take image about diagonal
        for(int row=0;row<n;row++){
            for(int col=row+1;col<n;col++){
                int temp = matrix[row][col];
                matrix[row][col]=matrix[col][row];
                matrix[col][row]=temp;
            }
        }
        
        return ;
    }
}
