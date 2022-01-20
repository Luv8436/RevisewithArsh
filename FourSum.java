import java.util.*;
public class FourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int n=arr.length;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        int i=0;
        while(i<n-3){
            int j = i+1;
            while(j<n-2){
                int target = k-arr[i]-arr[j];
                int left = j+1;
                int right = n-1;
                while(left<right){
                    if(arr[left]+arr[right]==target){
                        ArrayList<Integer> al = new ArrayList<>();
                        al.add(arr[i]);
                        al.add(arr[j]);
                        al.add(arr[left]);
                        al.add(arr[right]);
                        ans.add(al);
                        while(left<right&&arr[right]==arr[right-1] ){
                            right--;
                        }
                        right--;
                    }else if(arr[left]+arr[right]>target){
                        // decrease right
                        while(left<right&&arr[right]==arr[right-1] ){
                            right--;
                        }
                        right--;
                    }else{
                        // increase left
                        while(left<right&&arr[left]==arr[left+1] ){
                            left++;
                        }
                        left++;
                    }
                }
                while(j<n-2&&arr[j]==arr[j+1]){
                    j++;
                }
                j++;
                
            }
            while(i<n-3&&arr[i]==arr[i+1] ){
                i++;
            }
            i++;
        }
        
        return ans;
    }
}
