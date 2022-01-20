public class SticklerThiefTabulation {
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[][] dp = new int[n][2];
        dp[0][0] = arr[0];
        dp[0][1] = 0;
        for(int i=1;i<n;i++){
            dp[i][0] = arr[i]+dp[i-1][1];
            dp[i][1] = Integer.max(dp[i-1][0],dp[i-1][1] );
        }
        
        return Integer.max(dp[n-1][0],dp[n-1][1] );
    }
}
