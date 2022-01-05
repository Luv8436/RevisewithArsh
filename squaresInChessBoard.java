public class squaresInChessBoard {
    static Long squaresInChessBoardSolution(Long N) {
        // code here
        long sum=0;
        long i=1;
        while(i<=N){
            sum+=i*i;
            i++;
        }
        return sum;
    }
}
