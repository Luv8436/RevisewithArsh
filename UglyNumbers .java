class UglyNumbers  {
    long getNthUglyNo(int n) {
        // code here
        long[] dp = new long[n];
        dp[0]=1;
        
        int ptr2=0;
        int ptr3=0;
        int ptr5=0;
        
        for(int i=1;i<n;i++){
            long min = Long.min(2*dp[ptr2] , Long.min(3*dp[ptr3] , 5*dp[ptr5] ) );
            dp[i]=min;
            if(2*dp[ptr2]==min) ptr2++;
            if(3*dp[ptr3]==min) ptr3++;
            if(5*dp[ptr5]==min) ptr5++;
        }
        
        
        return dp[n-1];
    }
}
