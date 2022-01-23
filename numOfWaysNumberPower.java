public class numOfWaysNumberPower {
    static int numOfWays(int n, int x)
    {
        // code here
        Integer[][] dp = new Integer[n+1][n+1];
        return helper(n,x,1,dp);
    }
    static int helper(int n , int x,int number,Integer[][] dp ){
        if(n==0){
            return 1;
        }else if(number>n||n<0){
            return 0;
        }else if(dp[n][number]!=null ){
            return dp[n][number];
        }
        
        int c1 = helper(n,x,number+1,dp);
        int c2 = helper(n-(int)Math.pow(number,x) , x , number+1,dp);
        dp[n][number] = (c1+c2)%1000000007;
        return dp[n][number];
    }
}
