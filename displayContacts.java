import java.util.*;
public class displayContacts {
    static ArrayList<ArrayList<String>> displayContactsSolution(int n, 
                                        String contact[], String p)
    {
        // code here
        
        TrieNode Root = new TrieNode();
        for(int i=0;i<contact.length;i++){
            String s = contact[i];
            TrieNode ptr = Root;
            for(int j=0;j<s.length();j++){
                char ch = s.charAt(j);
                if(!ptr.hm.containsKey(ch)){
                    ptr.hm.put(ch , new TrieNode() );
                }
                ptr = ptr.hm.get(ch);
            }
            ptr.end=true;
        }
        
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        TrieNode ptr = Root;
        for(int i=0;i<p.length();i++ ){
            char ch = p.charAt(i);
            if(ptr.hm.containsKey(ch) ){
                ArrayList<String> al = getAllWords(ptr.hm.get(ch));
                String ss = p.substring(0 , i+1);
                for(int j=0;j<al.size();j++){
                    al.set(j , ss+al.get(j));
                }
                ptr = ptr.hm.get(ch);
                ans.add(al);
            }else{
                while(i<p.length() ){
                    ArrayList<String> al = new ArrayList<String>();
                    al.add("0");
                    ans.add(al);
                    i++;
                }
            }
        }
        
        // System.out.println("arraylist "+ans);
        

        return ans;
        
    }
    
    static ArrayList<String> getAllWords(TrieNode ptr){

        ArrayList<String> al = new ArrayList<String>();
        Object keys[] = ptr.hm.keySet().toArray();
        Arrays.sort(keys);
        for(Object key : keys ){
            ArrayList<String> temp = getAllWords(ptr.hm.get(key));
            for(int i=0;i<temp.size();i++ ){
                al.add(key+temp.get(i) );
            }
        }
        
        if(ptr.end){
            al.add(0,"");
        }
        
        return al;
    }
    static class TrieNode{
        HashMap<Character , TrieNode> hm;
        Boolean end;
        TrieNode(){
            this.end = false;
            this.hm = new HashMap<>();
        }
    }
}
