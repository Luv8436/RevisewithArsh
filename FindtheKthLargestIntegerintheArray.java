import java.util.*;
public class FindtheKthLargestIntegerintheArray {
    public String kthLargestNumber(String[] nums, int k) {
        PriorityQueue<String> pq = new PriorityQueue<>(k,(a,b)->{
            if(a.length()>b.length()) return 1;
            else if(a.length()<b.length()) return -1;
            return a.compareTo(b);
        }  );
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i] );
            if(pq.size()>k ){
                pq.remove();
            }
        }
        
        return pq.peek();
    }
}
