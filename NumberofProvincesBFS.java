import java.util.*;
public class NumberofProvincesBFS {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                count++;
                bfs(isConnected,i,visited);
            }
        }
        return count;
    }
    static void bfs(int[][] arr,int i,boolean[] visited){
        Queue<Integer> q = new ArrayDeque<>();
        q.add(i);
        while(q.size()>0 ){
            int city = q.remove();
            visited[city] = true;
            for(int j=0;j<arr.length;j++){
                if(visited[j]==false&&arr[city][j]==1 ){
                    q.add(j);
                }
            }
        }
    }
}
