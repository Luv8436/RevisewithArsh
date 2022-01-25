import java.util.*;
public class SmallestRangeInKLists {
    static int[] findSmallestRange(int[][] arr,int n,int k)
	{
	    //add your code here
	    int[] ans = new int[2];
	    ans[0]=-100000;
	    ans[1]=100000;
	    int max=Integer.MIN_VALUE;
	    PriorityQueue<Pair> pq = new PriorityQueue<>();
	    for(int i=0;i<k;i++){
	        max=Integer.max(max,arr[i][0]);
	        pq.add(new Pair(arr[i][0],i,0) );
	    }
	    
	    while(true){
	        Pair p = pq.remove();
	        int min = p.value;
	        if(ans[1]-ans[0]>max-min ){
	            ans[0]=min;
	            ans[1]=max;
	        }
	        
	        if(p.index==n-1){
	            break;
	        }
	        max = Integer.max(max,arr[p.row][p.index+1]);
	        pq.add(new Pair(arr[p.row][p.index+1],p.row,p.index+1));
	    }
	    
	    return ans;
	    
	    
	}
	static class Pair implements Comparable<Pair> {
	    int value;
	    int index;
	    int row;
	    Pair(int value,int row,int index){
	        this.value=value;
	        this.row=row;
	        this.index=index;
	    }
	    
	    public int compareTo(Pair o){
	        return this.value-o.value;
	    }
	}
}
