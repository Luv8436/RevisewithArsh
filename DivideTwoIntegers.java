public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1) return Integer.MAX_VALUE;

        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        int ans = 0;
        while(a-b>=0){
            int count=0 ;
            
            while(a-(b<<1<<count) >=0){
                
                count++;
            }
            ans += (1<<count);
            a = a-(b<<count);
        }
            
        
        return (long)dividend*divisor<0?-1*ans:ans ;
    }
}
