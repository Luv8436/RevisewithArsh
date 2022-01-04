public class canPair {
    public boolean canPairSolution(int[] nums, int k) {
        // Code here
        if(nums.length%2!=0) return false;
        int remainder[] = new int[k];
        for(int i=0;i<nums.length;i++){
            remainder[nums[i]%k]++;
        }
        
        int li=1;
        int ri=k-1;
        while(li<=ri){
            if(li!=ri&&remainder[li]!=remainder[ri]){
                return false;
            }else if(li==ri&&remainder[li]%2!=0 ){
                return false;
            }
            li++;
            ri--;
        }
        
        return true;
    }
}
