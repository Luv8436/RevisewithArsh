class Solution {
    
    public int countSubArrayProductLessThanK(long a[], long n, long k)
    {
        int i=0;
        int count=0;
        long product=1;
        for(int j=0;j<n;j++){
            product*=a[j];
            if(product<k){
                count+=(j-i+1);
                continue;
            }
            
            while(i<=j&&product>=k){
                product=product/a[i];
                i++;
            }
            
            count+=(j-i+1);
        }
        
        return count;
    }
}