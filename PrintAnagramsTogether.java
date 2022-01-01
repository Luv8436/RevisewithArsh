import java.util.*;
class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        HashMap<String , List<String>> hm = new HashMap<>();
        for(int i=0;i<string_list.length;i++){
            char[] charr = string_list[i].toCharArray();
            Arrays.sort(charr);
            String sorted = new String(charr);
            if(hm.containsKey(sorted)){
                hm.get(sorted).add(string_list[i]);
            }else{
                List<String> al =  new ArrayList<>();
                al.add(string_list[i]);
                hm.put(sorted , al);
            }
        }
        
        List<List<String>> ans = new ArrayList<List<String>>();
        for(String key : hm.keySet() ){
            List<String> subal = new ArrayList<>();
            for(String s : hm.get(key) ){
                // System.out.println(key+" "+s);
                subal.add(s);
            }
            ans.add(subal);
        }
        
        return ans;
    }
}
