public class PotsofGoldGame {
    public static int maxCoins(int A[],int n)
	{
          //add code here.
          int left = 0;
          int right = n-1;
          boolean turnX = true;
          Integer[][] dpX = new Integer[n][n];
          Integer[][] dpY = new Integer[n][n];
          return maxCoins(A,left,right,turnX,dpX,dpY);
    }
    static int maxCoins(int[] arr,int left,int right,boolean turnX,Integer[][] dpX,Integer[][] dpY){
        if(left>right){
            return 0;
        }else if(turnX&&dpX[left][right]!=null){
            return dpX[left][right];
        }else if(!turnX&&dpY[left][right]!=null ){
            return dpY[left][right];
        }
        
        if(turnX){
            int choice1 = arr[left] + maxCoins(arr,left+1,right,!turnX,dpX,dpY);
            int choice2 = arr[right] + maxCoins(arr,left,right-1,!turnX,dpX,dpY);
            dpX[left][right] = Integer.max(choice1,choice2);
            return Integer.max(choice1,choice2);
        }
        
        dpY[left][right] = Integer.min(maxCoins(arr,left,right-1,!turnX,dpX,dpY),maxCoins(arr,left+1,right,!turnX,dpX,dpY));
        return dpY[left][right] ;
    }
}
