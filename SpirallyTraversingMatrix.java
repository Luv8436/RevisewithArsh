import java.util.*;
public class SpirallyTraversingMatrix {
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        int minRow=0;
        int maxRow=r-1;
        int minCol=0;
        int maxCol=c-1;
        
        int count=0;
        ArrayList<Integer> ans = new ArrayList<>();
        while(count<r*c){
            // min col to max col in min row
            for(int col=minCol;col<=maxCol&&count<r*c;col++){
                ans.add(matrix[minRow][col]);
                count++;
            }
            minRow++;
            // min row to max row in max col
            for(int row=minRow;row<=maxRow&&count<r*c;row++){
                ans.add(matrix[row][maxCol]);
                count++;
            }
            maxCol--;
            // max col to min col in max row
            for(int col=maxCol;col>=minCol&&count<r*c;col--){
                ans.add(matrix[maxRow][col]);
                count++;
            }
            maxRow--;
            // max row to min row in min col
            for(int row=maxRow;row>=minRow&&count<r*c;row--){
                ans.add(matrix[row][minCol]);
                count++;
            }
            minCol++;
        }
        return ans;
    }
}
