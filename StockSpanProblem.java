public class StockSpanProblem {
    public static int[] calculateSpan(int price[], int n)
    {
        // Your code here
        int[] ans = new int[n];
        ans[0] = 1;
        for(int i=1;i<n;i++){
            ans[i]=1;
            int j=i-1;
            while(j>=0&&price[i]>=price[j]){
                ans[i]+=ans[j];
                j=j-ans[j];
            }
        }
        
        return ans;
    }
}
