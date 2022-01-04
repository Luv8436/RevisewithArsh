import java.util.PriorityQueue;

public class findMaxTen {
    public static void main(String args[]){
        int[] arr = {1,2,3,4,5,6,4,3,2,2,1,2,3,4,5,6,4,3,2,2,6,4,3,2,2,1,2,3,4,5,6,4,3,};
        int ans[] = findMaxTenFromTenMillion(arr);
        for(int item:ans){
            System.out.print(item+" ");
        }
    }

    static int[] findMaxTenFromTenMillion(int[] arr ){
        int[] ans = new int[10];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int index=0;index<arr.length;index++){
            if(pq.size()<10 ){
                pq.add(arr[index] );
            }else{
                if(pq.peek()<arr[index] ){
                    pq.remove();
                    pq.add(arr[index]);
                }
            }
        }
        int index=0;
        for(int item:pq){
            ans[index]=item;
            index++;
        }
        return ans;
    }
}
