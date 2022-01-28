public class NumberofProvinces {
    public int findCircleNum(int[][] isConnected) {
        int count=0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(isConnected , i , visited);
            }
        }
        return count;
    }
    static void dfs(int[][] arr,int i,boolean[] visited){
        if(visited[i]) return ;
        
        visited[i]=true;
        for(int j=0;j<arr.length;j++){
            if(arr[i][j]==1){
                dfs(arr,j,visited);
            }
        }
    }
}
