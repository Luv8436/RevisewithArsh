public class Minimumstepstodestination {
    static int minSteps(int D){
        // code here
        D = Math.abs(D);
        int src = 0;
        int step=1;
        while(src<D){
            src+=step;
            step++;
        }
        if(src==D){
            return step-1;
        }else if( (src-D)%2==0 ){
            return step-1;
        }else if(step%2!=0){
            return step;
        }else{
            return step+1;
        }
        
    }
}
