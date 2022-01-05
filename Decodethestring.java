public class Decodethestring {
    static String decodedString(String s){
        // code here
        if(s.length()==0){
            return "";
        }
        Stack<String> stk = new Stack<>();
        for(int index=s.length()-1;index>=0;index--){
            char ch = s.charAt(index);
            if(ch=='['){
                String temp = "";
                while(!stk.peek().equals("]")){
                    temp += stk.pop();
                }
                // for ]
                stk.pop();
                stk.push(temp);
            }else if(ch>='0'&&ch<='9'){
                String str = stk.pop();
                String count = "";
                while(index>=0&&s.charAt(index)>='0'&&s.charAt(index)<='9'){
                    count = s.charAt(index)+count;
                    index--;
                }
                index++;
                str = str.repeat(Integer.parseInt(count) );
                stk.push(str);
            }else{
                stk.push(""+ch);
            }
        }
        return stk.pop();
    }
}
