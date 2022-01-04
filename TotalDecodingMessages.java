class Solution
{
    public int CountWays(String str)
    {
        // code here
        if(str.charAt(0)=='0'){
            return 0;
        }
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0]=1;
        dp[1]=1;
        // 1234
        for(int i=2;i<=n;i++){
            char chcurr = str.charAt(i-1); // char at 1th index - 2
            char chprev = str.charAt(i-2); // char at prev index - 3
            if(chcurr!='0'){
                dp[i]+=dp[i-1];
            }
            int twoDigitNum = Integer.parseInt(""+chprev+chcurr);
            if(chprev!='0'&&twoDigitNum>=1&&twoDigitNum<=26){
                dp[i]+=dp[i-2];
            }
            dp[i] = dp[i]%1000000007;
        }
        
        return (int)(dp[n]%1000000007);
    }
    
   
}