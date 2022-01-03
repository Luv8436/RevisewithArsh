public class RunLengthEncoding {
	String encode(String str)
	{
          //Your code here
          int count=1;
          String ans="";
          for(int index=1;index<str.length();index++){
              if(str.charAt(index)==str.charAt(index-1) ){
                  count++;
              }else{
                  ans+= str.charAt(index-1);
                  ans+=count;
                  count=1;
              }
          }
          ans+= str.charAt(str.length()-1 );
          ans+=count;
          return ans;
	}
}
