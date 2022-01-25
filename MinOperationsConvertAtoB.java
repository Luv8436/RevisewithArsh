public class MinOperationsConvertAtoB {
    static int minInsAndDel(int[] A, int[] B, int N, int M) {
        // code here
        ArrayList<Integer> al = new ArrayList<>();
        int deletions = 0;
        for(int i=0;i<N;i++){
            if( bs(B,0,M-1,A[i])!=-1 ){
                al.add(A[i]);
            }else{
                deletions++;
            }
        }
        for(int i=0;i<al.size();i++){
            A[i]=al.get(i);
        }
        N=al.size();
        if(N==0){
            return deletions+M;
        }
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(A[0]);
        for(int i=1;i<N;i++){
            if(dp.get(dp.size()-1 )<A[i]){
                dp.add(A[i] );
            }else{
                int index = MinIndexGreaterThan(dp ,A[i]);
                dp.set(index,A[i] );
            }
        }
        
        int max = dp.size();
        
        // System.out.println(max+" "+N+" "+M);
        // System.out.println("deletions ="+deletions);
        int delete = N - max;
        // System.out.println("delete ="+delete);
        int insert = M-max;
        // System.out.println("insert ="+insert);
        return delete+insert+deletions;
    }
    static int MinIndexGreaterThan(ArrayList<Integer> dp,int key){
        int l=0;
        int r=dp.size()-1;
        
        while(l<=r){
            int mid=(l+r)/2;
            if(dp.get(mid)==key){
                return mid;
            }else if(dp.get(mid) > key ){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        
        return l;
        
    }
    
    // static int helper(int[] A,int[] B,int la,int lb){
    //     Integer[][] dp = new Integer[la+1][lb+1];
        
    //     for(int b=lb;b>=0;b--){
    //         for(int a=la;a>=0;a--){
    //             if(a==la||b==lb){
    //                 dp[a][b]=0;
    //             }else if(A[a]==B[b] ){
    //                 dp[a][b]=1+dp[a+1][b+1];
    //             }else{
    //                 dp[a][b]=Integer.max(dp[a][b+1],dp[a+1][b] );
    //             }
    //         }
    //     }
        
    //     return dp[0][0];
    // }
    
    static int bs(int[] arr,int l,int r,int key){
        if(l>r){
            return -1;
        }
        
        int mid=(l+r)/2;
        
        if(arr[mid]==key){
            return mid;
        }else if(arr[mid]<key){
            return bs(arr,mid+1,r,key);
        }else{
            return bs(arr,l,mid-1,key);
        }
    }
}
