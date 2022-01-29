import java.util.*;
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int ans[] = new int[n];
        int index=0;
        HashMap<Integer,ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0;i<n;i++){
            graph.put(i , new ArrayList<>() );
        }
        for(int i=0;i<prerequisites.length;i++){
            graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                boolean isCyclic = isCyclic(graph,i,visited,new boolean[n]);
                if(isCyclic) return new int[0];
            }
        }
        visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(visited[i]==false){
                Stack<Integer> stk = new Stack<>();
                topologicalSort(graph,i,visited,stk);
                int idx = index+stk.size()-1;
                index = idx+1;
                while(stk.size()>0 ){
                    ans[idx]=stk.pop();
                    idx--;
                }
            }
        }
        return ans;
    }
    static boolean isCyclic(HashMap<Integer,ArrayList<Integer>> graph,int i,boolean[] visited,boolean[] dfs){
        if(dfs[i] ) return true;
        
        dfs[i]=true;
        visited[i]=true;
        for(int dependant : graph.get(i) ){
            if(isCyclic(graph,dependant,visited,dfs)){
                return true;
            }
        }
        dfs[i]=false;
        
        return false;
    }
    static void topologicalSort(HashMap<Integer,ArrayList<Integer>> graph,int i,boolean[] visited,Stack<Integer> stk){
        visited[i]=true ;
        for(int course : graph.get(i)){
            if(visited[course]==false)
            topologicalSort(graph,course,visited,stk);
        }
        stk.push(i);
    }
}
