public class GuessNumberHigherorLowerII {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        return getMoneyAmount(1,n,dp);
    }
    static int getMoneyAmount(int left,int right,int[][] dp){
        if(left==right){
            return 0;
        }else if(left>right){
            return Integer.MIN_VALUE;
        }else if(dp[left][right]!=0){
            return dp[left][right];
        }
        int min = Integer.MAX_VALUE;
        for(int guess=left;guess<=right;guess++){
            min = Math.min(min , guess + Math.max( getMoneyAmount(left,guess-1,dp),getMoneyAmount(guess+1,right,dp) ) );
        }
        
        dp[left][right]=min;
        return min;
    }
}
