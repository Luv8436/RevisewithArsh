import java.util.*;
public class GenerateParentheses {
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> ans = generateParenthesis(n,0,0,0);
        return ans;
    }
    
    static List<String> generateParenthesis(int n,int index,int opening,int closing){
        if(index==n*2){
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        
        List<String> ans = new ArrayList<>();
        
        if(opening<n){
            List<String> startsWithOpening = generateParenthesis(n,index+1,opening+1,closing);
            for(String s : startsWithOpening){
                ans.add("("+s);
            }
        }
        
        
        if(closing<n&&opening>closing){
            List<String> startsWithClosing = generateParenthesis(n,index+1,opening,closing+1);
            for(String s : startsWithClosing){
                ans.add(")"+s);
            }
        }
        
        if(ans.size()==0 ){
            ans.add("");
            return ans;
        }
        return ans;
    }
}
