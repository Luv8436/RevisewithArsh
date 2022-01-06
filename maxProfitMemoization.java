public class maxProfitMemoization {
    static int maxProfit(int K, int N, int A[]) {
        // code here
        int[][] dp = new int[N][K+1];
        return maxProfit(K, A , 0 , dp);
    }
    static int maxProfit(int k , int[] arr , int index, int[][] dp ){
        if(index==arr.length||k==0){
            return 0;
        }else if(dp[index][k]!=0){
            return dp[index][k];
        }
        
        int max = maxProfit(k , arr , index+1 , dp);
        for(int i=index+1;i<arr.length;i++){
            if(arr[index]<arr[i]){
                max = Integer.max(max , arr[i]-arr[index]+maxProfit(k-1,arr,i,dp) );
            }
        }
        dp[index][k]=max;
        
        return max;
        
    }
}
