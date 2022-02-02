public class NumberofUniquePaths {
    //Function to find total number of unique paths.
    public static int NumberOfPath(int a, int b) 
    {
        //Your code here
        return solution(0,0,a-1,b-1);
    }
    static int solution(int sr,int sc,int dr,int dc){
        if(sr==dr&&sc==dc){
            return 1;
        }else if(sr>dr||sc>dc){
            return 0;
        }
        return solution(sr+1,sc,dr,dc)+solution(sr,sc+1,dr,dc);
    }
}
