import java.util.*;
public class FindArrayGivenSubsetSums {
    public int[] recoverArray(int n, int[] sums) {
        int[] ans = new int[n];
        int index=0;
        
        ArrayList<Integer> al = new ArrayList<Integer>();
        for(int val:sums){
            al.add(val);
        }
        recoverArray(ans,index,al );
        return ans;
    }
    static void recoverArray(int[] ans,int index,ArrayList<Integer> sums){
        if(sums.size()<=1 ){
            return ;
        }
        Collections.sort(sums);
        int diff = sums.get(sums.size()-1)-sums.get(sums.size()-2);
        ArrayList<Integer> excluding = new ArrayList<>();
        ArrayList<Integer> including = new ArrayList<>();
        HashMap<Integer,Integer> fr = freqCount(sums);
        for(int i=0;i<sums.size();i++){
            if(fr.get(sums.get(i) )>0 ){
                excluding.add(sums.get(i) );
                including.add(sums.get(i)+diff );
                fr.put(sums.get(i) , fr.get(sums.get(i) )-1 );
                fr.put(sums.get(i)+diff , fr.get(sums.get(i)+diff )-1 );
            }
        }
        
        if( !excluding.contains(0) ){
            excluding=including;
            ans[index]=-1*diff;
        }else{
            ans[index]=diff;
        }
        index++;
        
        recoverArray(ans,index,excluding);
    }
    static HashMap<Integer,Integer> freqCount(ArrayList<Integer> al){
        HashMap<Integer,Integer> fr = new HashMap<>();
        for(int val:al){
            if(fr.containsKey(val) ){
                fr.put(val , fr.get(val)+1 );
            }else{
                fr.put(val, 1);
            }
        }
        return fr;
    }
}
