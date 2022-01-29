public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int max=piles[0];
        int min=0;
        for(int i=0;i<piles.length;i++){
            max=Integer.max(max,piles[i] );
        }
        while(min<=max){
            int mid=(min+max)/2;
            if(isPossible(piles,h,mid) ){
                max=mid-1;
            }else{
                min=mid+1;
            }
        }
        return min;
    }
    static boolean isPossible(int[] arr,int h,int mid){
        for(int i=0;i<arr.length;i++){
            h = h-(int)Math.ceil((arr[i]*1.0)/mid);
            if(h<0) return false;
        }
        if(h>=0) return true;
        return false;
    }
}
