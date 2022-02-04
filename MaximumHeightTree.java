public class MaximumHeightTree {
    static int height(int N){
        // code here
        int dots = 0;
        int dot = 1;
        int height=0;
        while(dots+dot<=N){
            height++;
            dots+=dot;
            dot++;
        }
        return height;
    }
}
