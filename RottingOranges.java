import java.util.*;
public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        // count the rotten oranges and also mark them in the visited arr        
        int freshCount = 0;
        Queue<Pair> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    freshCount++;
                }else if(grid[i][j]==2){
                    q.add(new Pair(i , j));
                }
            }
        }
        
        int t=0;
        while(freshCount>0&&q.size()>0){
            t++;
            int size = q.size();
            for(int i=0;i<size;i++){
                Pair p = q.remove();
                freshCount -= rottingOranges(grid , p.x , p.y , q);
            }
            // System.out.println("size "+q.size());
        }
        
        if(freshCount!=0) return -1;
        
        
        return t;
    }
    
    static int rottingOranges(int[][] grid , int x , int y , Queue<Pair> q){
        int count = 0;
        if(insideGrid(grid , x+1 , y)&&grid[x+1][y]==1 ){
            count++;
            q.add(new Pair(x+1 , y) );
            grid[x+1][y]=2;
        }
        if(insideGrid(grid , x , y+1)&&grid[x][y+1]==1 ){
            count++;
            q.add(new Pair(x , y+1) );
            grid[x][y+1]=2;
        }
        if(insideGrid(grid , x-1 , y)&&grid[x-1][y]==1 ){
            count++;
            q.add(new Pair(x-1 , y) );
            grid[x-1][y]=2;
        }
        if(insideGrid(grid , x , y-1)&&grid[x][y-1]==1){
            count++;
            q.add(new Pair(x , y-1) );
            grid[x][y-1]=2;
        }
        
        
        return count;
    }
    
    static boolean insideGrid(int[][] grid , int x , int y){
        if(x>=0&&y>=0&&x<grid.length&&y<grid[0].length){
            return true;
        }
        
        return false;
    }
    
    static class Pair{
        int x;
        int y;
        Pair(int x , int y){
            this.x=x;
            this.y=y;
        }
    }
}
