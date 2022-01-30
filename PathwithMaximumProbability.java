import java.util.*;
public class PathwithMaximumProbability {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        
        HashMap<Integer,ArrayList<Pair>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i,new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            graph.get(edges[i][0]).add(new Pair(edges[i][1],succProb[i]) );
            graph.get(edges[i][1]).add(new Pair(edges[i][0],succProb[i]) );
        }
        
        boolean[] visited = new boolean[n];
        Queue<Pair> q = new PriorityQueue<>();
        q.add(new Pair(start , 1) );
        while(q.size()>0 ){
            Pair p = q.remove();
            // System.out.println(p.vertex+" "+p.probability );
            if(visited[p.vertex]) continue;
            visited[p.vertex]=true;
            if(p.vertex==end){
                return p.probability;
            }
            for(Pair nbr : graph.get(p.vertex) ){
                if(visited[nbr.vertex]==false ){
                    // System.out.println("add "+nbr.vertex+" prob: "+p.probability*nbr.probability);
                    q.add(new Pair(nbr.vertex , p.probability*nbr.probability) );
                }
            }   
        }
        
        return 0;
    }
    
    static class Pair implements Comparable<Pair> {
        int vertex;
        double probability;
        Pair(int vertex,double probability){
            this.vertex=vertex;
            this.probability=probability;
        }
        public int compareTo(Pair o){
            if(o.probability==this.probability){
                return 0;
            }else if(o.probability>this.probability){
                return 1;
            }else{
                return -1;
            }
        }
    }
}
