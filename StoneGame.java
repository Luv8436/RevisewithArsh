public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        int alice = stoneGame(piles,0,piles.length-1,dp);
        int total=0;
        for(int val:piles){
            total+=val;
        }
        return total-alice>alice?false:true;
    }
    static int stoneGame(int[] arr,int l,int r,int[][] dp){
        if(l>r){
            return 0;
        }else if(dp[l][r]!=0){
            return dp[l][r];
        }
        dp[l][r]= Integer.max( arr[l]+Integer.min(stoneGame(arr,l+2,r,dp),stoneGame(arr,l+1,r-1,dp) ) , arr[r]+Integer.min(stoneGame(arr,l+1,r-1,dp),stoneGame(arr,l,r-2,dp) )  );
        return dp[l][r];
        
    }
}
