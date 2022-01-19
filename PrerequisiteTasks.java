import java.util.*;
public class PrerequisiteTasks {
    public boolean isPossible(int N, int[][] pre)
    {
        // Your Code goes here
        ArrayList<Integer>[] graph = new ArrayList[N];
        for(int i=0;i<N;i++){
            graph[i]=new ArrayList<>();
        }
        
        for(int i=0;i<pre.length;i++){
            graph[pre[i][1]].add(pre[i][0]);
        }
        boolean[] visited = new boolean[N];
        for(int v=0;v<N;v++){
            if(visited[v]==false ){
                boolean[] dfs = new boolean[N];
                boolean ans = isCycle(graph,v,visited,dfs);
                if(ans) return false;
            }
        }
        
        return true;
    }
    
    static boolean isCycle(ArrayList<Integer>[] graph,int src,boolean[] visited,boolean[] dfs){
        if(dfs[src]) return true;
        if(visited[src]) return false;
        
        visited[src]=true;
        dfs[src]=true;
        for(int nbr : graph[src]){
            boolean ans = isCycle(graph,nbr,visited,dfs);
            if(ans) return true;
        }
        dfs[src]=false;
        
        
        return false;
    }
}
