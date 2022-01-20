import java.util.*;
public class BridgeEdgeInAgraph {
    //Function to find if the given edge is a bridge in graph.
    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj,int c,int d)
    {
        // code here
        boolean[] visited=new boolean[V];
        adj.get(c).remove(new Integer(d) );
        adj.get(d).remove(new Integer(c) );
        boolean hasPath = hasPath(adj,c,d,visited);
        if(hasPath) return 0;
        
        return 1;
    }
    static boolean hasPath(ArrayList<ArrayList<Integer>> adj,int src,int dest,boolean[] visited){
        if(src==dest){
            return true;
        }else if(visited[src] ){
            return false;
        }
        visited[src]=true;
        
        for(int nbr : adj.get(src) ){
            boolean ans = hasPath(adj,nbr,dest,visited);
            if(ans) return true;
        }
        
        return false;
    }
        
}
