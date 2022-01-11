public class longestMountain {
    public int longestMountainSolution(int[] arr) {
        int i=0;
        int max=0;
        while(i<arr.length-1){
            while(i<arr.length-1&&arr[i+1]<=arr[i] ){
                i++;
            }
            int left=0;
            while(i<arr.length-1&&arr[i+1]>arr[i] ){
                i++;
                left++;
            }
            int right=0;
            while(i<arr.length-1&&arr[i+1]<arr[i] ){
                i++;
                right++;
            }
            if(left==0||right==0){
                continue;
            }
            int length = left+right+1;
            if(length>max){
                max = length;
            }
        
        }
        return max;
    }
}
