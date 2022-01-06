public class maxProfit {
    static int maxProfitSolution(int K, int N, int A[]) {
        // code here
        int[][] dp = new int[K+1][N];
        for(int day=0;day<N;day++){
            dp[0][day]=0;
        }
        for(int transaction=0;transaction<=K;transaction++){
            dp[transaction][0]=0;
        }
        
        for(int transaction=1;transaction<=K;transaction++){
            for(int day=1;day<N;day++){
                int profit = dp[transaction][day-1];
                for(int pday=0;pday<day;pday++){
                    profit = Integer.max(profit , dp[transaction-1][pday]+A[day]-A[pday] );
                }
                dp[transaction][day]=profit;
            }
        }
        
        return dp[K][N-1];
    }
}
