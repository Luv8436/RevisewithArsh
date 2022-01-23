public class PotsOfGoldGameRecursiveDP {
    public static int maxCoins(int A[],int n)
	{
          //add code here.
          int left = 0;
          int right = n-1;
          int[][] dp = new int[n][n];
          return maxCoins(A,left,right,dp);
    }
    static int maxCoins(int[] arr,int left,int right,int[][] dp ){
        if(left>right){
            return 0;
        }else if(dp[left][right]!=0 ){
            return dp[left][right];
        }
        dp[left][right]=Integer.max(arr[left]+Integer.min(maxCoins(arr,left+2,right,dp),maxCoins(arr,left+1,right-1,dp) ),
                           arr[right]+Integer.min(maxCoins(arr,left+1,right-1,dp),maxCoins(arr,left,right-2,dp)) );
        return dp[left][right] ;
        
    }
}
