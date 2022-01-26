public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int l=0;
        int r=0;
        for(int val: nums){
            r+=val;
        }
        int ans = r;
        while(l<=r){
            int mid = (l+r)/2;
            boolean isPossible = canSplitArray(nums,m,mid,0);
            if(isPossible){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return ans;
    }
    static boolean canSplitArray(int[] arr,int k,int max,int index){
        if(index==arr.length){
            if(k>=0) return true;
            return false;
        }
        int sum=0;
        if(arr[index]>max){
            return false;
        }
        while(index<arr.length&&sum+arr[index] <= max){
            sum += arr[index];
            index++;
        }
        return canSplitArray(arr,k-1,max,index);
    }
}
