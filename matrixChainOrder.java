public class matrixChainOrder{
    static String matrixChainOrderSolution(int p[], int n){
        // code here
        Pair[][] dp = new Pair[p.length-1][p.length-1];
		return mcm(p , 0 , p.length-2 , dp).s;
    }
    static Pair mcm(int[] arr , int l , int r , Pair[][] dp ){
	    if(l==r){
	        return new Pair(0 , (char)('A'+l)+""  ) ;
	    }else if(dp[l][r]!=null ){
	        return dp[l][r];
	    }
	    int min = Integer.MAX_VALUE;
	    String smin = "";
	    for(int i=l+1;i<=r;i++){
	        Pair right = mcm(arr , i , r , dp);
	        Pair left = mcm(arr , l , i-1 , dp);
	        int minimum = left.num+right.num+arr[l]*arr[i]*arr[r+1];
	        if(minimum<min){
	            min = minimum;
	            smin = "("+left.s+right.s+")";
	        }
	    }
	    dp[l][r] = new Pair(min , smin);
	    return dp[l][r];
	}
	static class Pair{
	    int num;
	    String s;
	    Pair(int num,String s){
	        this.num=num;
	        this.s=s;
	    }
	}
}