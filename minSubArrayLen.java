public class minSubArrayLen {
    public int minSubArrayLenSolution(int target, int[] nums) {
        int sum=0;
        int si=0;
        int minLength=Integer.MAX_VALUE;
        for(int index=0;index<nums.length;index++){
            sum+=nums[index];
            while(si<=index&&sum>=target){
                int length = index-si+1;
                if(length<minLength){
                    minLength=length;
                }
                sum=sum-nums[si];
                si++;
            }
        }
        if(minLength!=Integer.MAX_VALUE){
            return minLength;
        }
        
        return 0;
    }
}
