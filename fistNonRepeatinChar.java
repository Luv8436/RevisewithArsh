import java.util.*;
import java.io.*;
public class fistNonRepeatinChar
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        StringBuilder ans = new StringBuilder("");
        int[] fr = new int[256];
        Queue<Character> q = new ArrayDeque<>();
        for(int index=0;index<A.length();index++){
            char ch = A.charAt(index);
            fr[ch]++;
            if(fr[ch]==1 ){
                q.add(ch);
            }
            while(q.size()>0&&fr[q.peek() ]!=1){
                q.remove();
            }
            if(q.size()==0 ){
                ans.append('#');
            }else{
                ans.append(q.peek());
            }
        }
        return ans.toString();
    }
    
}