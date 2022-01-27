public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int l=Integer.MAX_VALUE;
        int r=0;
        for(int value:weights){
            l=Integer.min(l,value);
            r+=value;
        }
        
        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(weights,days,mid)){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return l;
    }
    static boolean isPossible(int[] arr,int days,int maxWeight){
        int index=0;
        while(days-->0){
            int weight=0;
            while(index<arr.length&&weight+arr[index]<=maxWeight){
                weight+=arr[index];
                index++;
            }
            if(index==arr.length) return true;
        }
        
        return false;
    }
}
