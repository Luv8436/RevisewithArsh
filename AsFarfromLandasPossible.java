import java.util.*;
public class AsFarfromLandasPossible {
    public int maxDistance(int[][] grid) {
        Queue<Point> q = new ArrayDeque<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==1){
                    q.add(new Point(i,j) );
                }
            }
        }
        if(q.size()==0||q.size()==grid.length*grid.length){
            return -1;
        }
        int max=-1;
        while(q.size()>0){
            max++;
            int size = q.size();
            for(int i=0;i<size;i++){
                Point p = q.remove();
                if(p.x-1>=0&&grid[p.x-1][p.y]==0){
                    grid[p.x-1][p.y]=1;
                    q.add(new Point(p.x-1,p.y) );
                }
                if(p.y-1>=0&&grid[p.x][p.y-1]==0){
                    grid[p.x][p.y-1]=1;
                    q.add(new Point(p.x,p.y-1) );
                }
                if(p.x+1<grid.length&&grid[p.x+1][p.y]==0){
                    grid[p.x+1][p.y]=1;
                    q.add(new Point(p.x+1,p.y) );
                }
                if(p.y+1<grid.length&&grid[p.x][p.y+1]==0){
                    grid[p.x][p.y+1]=1;
                    q.add(new Point(p.x,p.y+1) );
                }
            }
        }
        
        return max;
    }
    static int maxDistance(int[][] grid,int i,int j){
        boolean[][] visited = new boolean[grid.length][grid.length];
        Queue<Point> q = new ArrayDeque<>();
        q.add(new Point(i,j) );
        while(q.size()>0){
            Point p = q.remove();
            visited[p.x][p.y]=true;
            if(grid[p.x][p.y]==1 ){
                return Math.abs(p.x-i)+Math.abs(p.y-j);
            }
            
        }
        return -1;
    }
    static class Point{
        int x;
        int y;
        Point(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}
