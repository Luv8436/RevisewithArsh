import java.util.*;
public class max_of_subarrays {
    static ArrayList<Integer> max_of_subarraysSolution(int arr[], int n, int k) {
        // Your code here
        Stack<Integer> stk = new Stack<>();
        int[] ngi = new int[n];
        ngi[n-1]=n;
        stk.push(n-1);
        for(int index=n-2;index>=0;index--){
            
            while(stk.size()>0&&arr[index]>=arr[stk.peek()] ){
                stk.pop();
            }
            
            if(stk.size()==0 ){
                ngi[index]=n;
            }else{
                ngi[index]=stk.peek();
            }
            
            stk.push(index);
        }
        
        int j=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int index=0;index<=n-k;index++){
            if(j<index) j=index;
            while(ngi[j]>=index&&ngi[j]<index+k){
                j=ngi[j];
            }
            ans.add(arr[j] );
        }
        
        return ans;
        
        
    }
}
