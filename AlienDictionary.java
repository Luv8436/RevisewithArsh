import java.util.*;
public class AlienDictionary {
    public String findOrder(String [] dict, int N, int K)
    {
        // Write your code here
        char arr[] = new char[K];
        char ch = 'a';
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<K;i++){
            char chi = (char)(ch+i);
            arr[i]= chi ;
            hm.put(chi , i);
        }
        for(int index=1;index<N;index++){
            int i=0;
            int j=0;
            while(i<dict[index-1].length()&&j<dict[index].length()&&dict[index-1].charAt(i)==dict[index].charAt(j) ){
                i++;
                j++;
            }
            
            if(i<dict[index-1].length()&&j<dict[index].length() ){
                char ch1 = dict[index-1].charAt(i);
                char ch2 = dict[index].charAt(j);
                int index1 = hm.get(ch1);
                int index2 = hm.get(ch2);
                if(index2<index1){
                    char temp = arr[index1];
                    arr[index1] = arr[index2];
                    arr[index2] = temp;
                    hm.put(ch1,index2);
                    hm.put(ch2,index1);
                }
            }
        }
        
        return arr.toString();
        
        
        
        
    }
}
