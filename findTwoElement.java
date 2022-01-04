public class findTwoElement {
    int[] findTwoElementSolution(int arr[], int n) {
        // code here
        int xor = 0;
        for(int index=0;index<n;index++){
            xor = xor^arr[index]^(index+1);
        }
        
        int mask=1;
        while((mask&xor)==0){
            mask = mask<<1;
        }
        
        int xorset = 0;
        int xorunset = 0;
        for(int index=0;index<n;index++){
            if((mask&arr[index])==0){
                xorunset=xorunset^arr[index];
            }else{
                xorset=xorset^arr[index];
            }
            if((mask&(index+1))==0){
                xorunset=xorunset^(index+1);
            }else{
                xorset=xorset^(index+1);
            }
        }
        int[] ans = new int[2];
        for(int i=0;i<arr.length;i++){
            if(arr[i]==xorunset){
                ans[0]=xorunset;
                ans[1]=xorset;
                return ans;
            }else if(arr[i]==xorset){
                ans[0]=xorset;
                ans[1]=xorunset;
                return ans;
            }
        }
        return ans;
    }
}
