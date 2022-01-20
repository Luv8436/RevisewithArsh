public class maximumIslandArea {
    //Function to find unit area of the largest region of 1s.
    public int findMaxArea(int[][] grid)
    {
        // Code here
        int rows=grid.length;
        int cols=grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        int maxArea = 0;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    int area = calculateArea(grid,visited,rows,cols,i,j);
                    if(area>maxArea){
                        maxArea = area;
                    }
                }
            }
        }
        
        return maxArea;
    }
    static int calculateArea(int[][] grid,boolean[][] visited,int rows,int cols,int i,int j){
        if(i<0||j<0||i==rows||j==cols||visited[i][j]||grid[i][j]==0){
            return 0;
        }
        
        visited[i][j]=true;
        int count=0;
        count += calculateArea(grid,visited,rows,cols,i+1,j);
        count += calculateArea(grid,visited,rows,cols,i,j+1);
        count += calculateArea(grid,visited,rows,cols,i-1,j);
        count += calculateArea(grid,visited,rows,cols,i,j-1);
        count += calculateArea(grid,visited,rows,cols,i-1,j-1);
        count += calculateArea(grid,visited,rows,cols,i+1,j+1);
        count += calculateArea(grid,visited,rows,cols,i+1,j-1);
        count += calculateArea(grid,visited,rows,cols,i-1,j+1);
        
        return count+1;
    }
}
