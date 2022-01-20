import java.util.*;
public class GenerateBinaryNumbers {
    //Function to generate binary numbers from 1 to N using a queue.
    static ArrayList<String> generate(int N)
    {
        // Your code here
        ArrayList<String> ans = new ArrayList<String>();
        for(int i=1;i<=N;i++){
            ans.add(toBinary(i) );
        }
        return ans;
    }
    static String toBinary(int n){
        String ans = "";
        while(n>0){
            ans=(n%2)+ans;
            n=n/2;
        }
        
        return ans;
    }
}
