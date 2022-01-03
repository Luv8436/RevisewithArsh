public class PosInCircle {
    static int findPosition(int N , int M , int K) {
        // code here
        return ((K-1+M-1)%N)+1;
    }
}
