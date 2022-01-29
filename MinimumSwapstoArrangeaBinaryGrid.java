public class MinimumSwapstoArrangeaBinaryGrid {
    public int minSwaps(int[][] grid) {
        int index=0;
        int[] arr = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            int count=0;
            for(int j=grid.length-1;j>=0&&grid[i][j]==0;j--){
                count++;
            }
            arr[index++]=count;
        }
        
        int ans=0;
        for(int i=0;i<grid.length;i++){
            int j=i;
            while(j<grid.length&&arr[j]<grid.length-i-1){
                j++;
            }
            if(j==grid.length) return -1;
            for(int k=j;k>i;k--){
                int temp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = temp;
            }
            ans+=(j-i);
        }
        
        return ans;
    }
}
