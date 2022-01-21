import java.util.*;
public class SubarrayWithGivenSum {
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        int leftIndex=0;
        int rightIndex=0;
        int sum=0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        while(rightIndex<n){
            sum+=arr[rightIndex];
            while(leftIndex<=rightIndex&&sum>=s){
                if(sum==s){
                    ans.add(leftIndex+1);
                    ans.add(rightIndex+1);
                    return ans;
                }
                sum-=arr[leftIndex];
                leftIndex++;
            }
            rightIndex++;
        }
        ans.add(-1);
        return ans;
    }
}
