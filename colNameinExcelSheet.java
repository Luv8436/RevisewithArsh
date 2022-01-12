public class colNameinExcelSheet {
    String colName (long n)
    {
        // your code here
        StringBuilder ans = new StringBuilder();
        while(n>0){
            char ch = (char)((n-1)%26+'A');
            ans.insert(0 , ch);
            n = (n-1)/26;
        }
        
        return ans.toString();
        
    }
}
