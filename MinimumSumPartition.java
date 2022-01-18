public class MinimumSumPartition {
    public int minDifference(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    for(int item:arr){
	        sum+=item;
	    }
	    
	    int target=sum/2;
	    Boolean[][] dp = new Boolean[target+1][n+1];
	    for(int i=target;i>=0;i--){
	        boolean ans = targetSum(arr , 0 , i,dp);
	        if(ans){
	           // System.out.println(i);
	            return (sum-i)-i;
	        }
	    }
	    return 0;
	} 
	static boolean targetSum(int[] arr,int index,int target,Boolean[][] dp){
	    if(index==arr.length){
	        if(target!=0){
	            return false;
	        }
	        
	        return true;
	    }else if(target<0){
	        return false;
	    }
	    else if(dp[target][index]!=null ){
	        return dp[target][index];
	    }
	    
	    boolean ans1 = targetSum(arr,index+1,target,dp);
	    boolean ans2 = targetSum(arr,index+1,target-arr[index],dp);
	    if(ans1||ans2){
	        dp[target][index]=true;
	        return true;
	    }
	    
	    dp[target][index]=false;
	    return false;
	}
}
