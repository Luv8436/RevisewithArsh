public class ImplementAtoi {
    int atoi(String str) {
        int n = 0;
        boolean pos = true;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            if(ch>='0'&&ch<='9')
            n=n*10+Integer.parseInt(""+ch);
            else if(i==0&&ch=='-'){
                pos=false;
            }
            else return -1;
        }
        if(!pos) return -1*n;
        return n;
    }
}
