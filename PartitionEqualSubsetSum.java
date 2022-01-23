
public class PartitionEqualSubsetSum {
    static int equalPartition(int N, int arr[])
    {
        // code here
        int sum = 0;
        for(int val : arr){
            sum+=val;
        }
        
        if(sum%2!=0){
            return 0;
        }
        
        Integer[][] dp = new Integer[N][sum/2+1];
        return helper(arr,0,sum/2,dp);
    }
    
    static int helper(int[] arr,int index,int target,Integer[][] dp){
        if(index==arr.length||target<0 ){
            if(target==0){
                return 1;
            }
            
            return 0;
        }else if(dp[index][target]!=null){
            return dp[index][target];
        }
        int ans1 = helper(arr,index+1,target-arr[index] ,dp);
        int ans2 = helper(arr,index+1,target,dp);
        
        if(ans1==1||ans2==1){
            dp[index][target]=1;
            return 1;
        }
        
        dp[index][target]=0;
        return 0;
    }

}
