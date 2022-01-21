public class LongestArithmeticProgression {
    int lengthOfLongestAP(int[] arr, int n) {
        // code here
        if(n==1){
            return 1;
        }else if(n==0){
            return 0;
        }
        int max = 2;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int diff = arr[j]-arr[i];
                int num = arr[j]+diff;
                int count=0;
                int k=j+1;
                while(k<n){
                    if(arr[k]==num){
                        count++;
                        num+=diff;
                    }else if(arr[k]>num){
                        break;
                    }
                    k++;
                }
                if(count!=0){
                    max=Integer.max(max,count+2);
                }
            }
        }
        
        return max;
    }
}
