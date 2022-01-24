public class AmendTheSentence {
    public String amendSentence(String s){
        //code here
        StringBuilder ans = new StringBuilder("");
        char fc = s.charAt(0);
        // A + a - 'A'
        if(fc>='A'&&fc<='Z')
        ans.append( (char)(fc+'a'-'A') );
        else
        ans.append(fc);
        for(int i=1;i<s.length();i++ ){
            char ch = s.charAt(i);
            if(ch>='A'&&ch<='Z'){
                ans.append(" ");
                ans.append((char)(ch+'a'-'A') );
            }else{
                ans.append(ch);
            }
        }
        
        return ans.toString();
    }
}
