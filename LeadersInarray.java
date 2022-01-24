import java.util.*;
public class LeadersInarray {
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(arr[n-1]);
        int index = n-2;
        int max = arr[n-1];
        while(index>=0){
            if(arr[index]>=max){
                ans.add(0,arr[index]);
                max=arr[index];
            }
            index--;
        }
        
        return ans;
        
    }
}
