public class countWays {
    Long countWaysSolution(int m)
    {
        // your code here
        return countWaysSolution(m , true);
    }
    long countWaysSolution(int n , boolean flag){
        if(n==0){
            return 1;
        }else if(n<0){
            return 0;
        }
        if(flag){
            return countWaysSolution(n-1 , true)+countWaysSolution(n-2 , false);
        }
        return countWaysSolution(n-2 , false);
        
    }
}
