import java.util.*;
public class SortedSubsequenceOfSize3 {
    ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        // add code here.
        int[] ng = new int[n];
        Stack<Integer> stk = new Stack<>();
        ng[n-1]=n;
        stk.push(n-1);
        for(int index=n-2;index>=0;index--){
            int curr = arr.get(index);
            while(stk.size()>0 && arr.get(stk.peek()) <= curr ){
                stk.pop();
            }
            if(stk.size()==0){
                ng[index]=n;
            }else{
                ng[index]=stk.peek();
            }
            
            stk.push(index);
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i=0;i<n-3;i++){
            if(ng[i]<n&&ng[ng[i]]<n){
                ans.add(arr.get(i) );
                ans.add(arr.get(ng[i]) );
                ans.add(arr.get(ng[ng[i]]) );
                return ans;
            }
        }
        return ans;
    }
}
