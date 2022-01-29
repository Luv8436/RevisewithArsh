import java.util.*;
public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        Queue<Point> pacific = new ArrayDeque<>();
        Queue<Point> atlantic = new ArrayDeque<>();
        boolean[][] pv = new boolean[n][m];
        boolean[][] av = new boolean[n][m];
        for(int i=0;i<n;i++){
            pv[i][0]=true;
            pacific.add(new Point(i,0) );
            av[i][m-1]=true;
            atlantic.add(new Point(i,m-1) );
        }
        for(int i=0;i<m;i++){
            pacific.add(new Point(0,i) );
            pv[0][i]=true;
            av[n-1][i]=true;
            atlantic.add(new Point(n-1,i) );
        }
        
        while(pacific.size()>0 ){
            Point p = pacific.remove();
            if(p.y-1>=0&&!pv[p.x][p.y-1]&&heights[p.x][p.y]<=heights[p.x][p.y-1] ){
                pv[p.x][p.y-1]=true;
                pacific.add(new Point(p.x,p.y-1) );
            }
            if(p.x+1<n&&!pv[p.x+1][p.y]&&heights[p.x][p.y]<=heights[p.x+1][p.y]){
                pv[p.x+1][p.y]=true;
                pacific.add(new Point(p.x+1,p.y) );
            }
            if(p.y+1<m&&!pv[p.x][p.y+1]&&heights[p.x][p.y]<=heights[p.x][p.y+1]){
                pv[p.x][p.y+1]=true;
                pacific.add(new Point(p.x,p.y+1) );
            }
            if(p.x-1>=0&&!pv[p.x-1][p.y]&&heights[p.x][p.y]<=heights[p.x-1][p.y]){
                pv[p.x-1][p.y]=true;
                pacific.add(new Point(p.x-1,p.y) );
            }
        }
        
        
        while(atlantic.size()>0 ){
            Point p = atlantic.remove();
            if(p.y-1>=0&&!av[p.x][p.y-1]&&heights[p.x][p.y]<=heights[p.x][p.y-1] ){
                av[p.x][p.y-1]=true;
                atlantic.add(new Point(p.x,p.y-1) );
            }
            if(p.x+1<n&&!av[p.x+1][p.y]&&heights[p.x][p.y]<=heights[p.x+1][p.y]){
                av[p.x+1][p.y]=true;
                atlantic.add(new Point(p.x+1,p.y) );
            }
            if(p.y+1<m&&!av[p.x][p.y+1]&&heights[p.x][p.y]<=heights[p.x][p.y+1]){
                av[p.x][p.y+1]=true;
                atlantic.add(new Point(p.x,p.y+1) );
            }
            if(p.x-1>=0&&!av[p.x-1][p.y]&&heights[p.x][p.y]<=heights[p.x-1][p.y]){
                av[p.x-1][p.y]=true;
                atlantic.add(new Point(p.x-1,p.y) );
            }
        }
        
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(av[i][j]&&pv[i][j]){
                    ArrayList<Integer> al = new ArrayList<>();
                    al.add(i);
                    al.add(j);
                    ans.add(al);
                }
            }
        }
        
        return ans;
        
        
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
