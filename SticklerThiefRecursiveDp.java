public class SticklerThiefRecursiveDp {
    //Function to find the maximum money the thief can get.
    public int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int[][] dp = new int[n][2];
        return findSumHelper(arr,0,0,dp);
    }
    static int findSumHelper(int[] arr,int index,int flag,int[][] dp){
        if(index==arr.length){
            return 0;
        }else if(dp[index][flag]!=0 ){
            return dp[index][flag];
        }
        
        if(flag==1){
            // previous element is taken
            // skip this element
            dp[index][flag]= findSumHelper(arr,index+1,0,dp);
            return dp[index][flag];
        }else{
            dp[index][flag] = Integer.max(findSumHelper(arr,index+1,0,dp),arr[index]+findSumHelper(arr,index+1,1,dp) );
            return dp[index][flag];
        }
    }
}
