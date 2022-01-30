import java.util.*;
public class FindtheMissingNoInString {
    static int ans;
	public int missingNumber(String s)
   {
   //add code here.
        ans = -1;
        for(int i=1;i<=6&&i<=s.length();i++){
            String ss = s.substring(0,i);
            ArrayList<Integer> al = new ArrayList<>();
            int start = Integer.parseInt(ss);
            al.add(start);
            int missing = findMissing(s,i,start,al);
            al.remove(al.size()-1 );
            if(missing!=-1) return missing;
        }
        
        return -1;
   }
   static int findMissing(String s , int index , int prev,ArrayList<Integer> al){
       if(index==s.length()){
        //   System.out.println(al);
          if(al.get(0)+al.size()!=al.get(al.size()-1) ) return -1;
            return ans;
        //   return checkMissing(al,0,al.size()-1);
       }
       String prev1 = (prev+1)+"";
       if(index+prev1.length()<=s.length()){
           String ss = s.substring(index,index+prev1.length());
           if(Integer.parseInt(prev1)==Integer.parseInt(ss) ){
               int num = Integer.parseInt(prev1);
               al.add(Integer.parseInt(prev1) );
               int missing = findMissing(s,index+prev1.length(),num,al);
               al.remove(al.size()-1);
               if(missing!=-1) return missing;
           }
       }
       
        String prev2 = (prev+2)+"";
       if(index+prev2.length()<=s.length()){
           ans = prev+1;
           String ss = s.substring(index,index+prev2.length());
           if(Integer.parseInt(prev2)==Integer.parseInt(ss) ){
               int num = Integer.parseInt(prev2);
               al.add(Integer.parseInt(prev2) );
               int missing = findMissing(s,index+prev2.length(),num,al);
               al.remove(al.size()-1);
               if(missing!=-1) return missing;
           }
       }
       
       return -1;
       
   }
}
