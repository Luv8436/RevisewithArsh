public class LargestNumberKswaps {
    //Function to find the largest number after k swaps.
    static String max;
    public static String findMaximumNum(String str, int k)
    {
        //code here.
        char[] ch = str.toCharArray();
        max = "0";
        findMax(ch , k , 0);
        return new String(max+"");
    }
    
    static void findMax(char[] ch , int k ,int index){
        if(index==ch.length||k==0){
            String s = new String(ch);
            // System.out.println(s);
            if(max.compareTo(s)<0 ){
                max = s;
            }
            
            return ;
        }
        
        findMax(ch,k,index+1);
        
        for(int i=index+1;i<ch.length;i++){
            swap(ch,index,i);
            findMax(ch,k-1,index+1);
            swap(ch,index,i);
        }
        
    }
    
    static void swap(char[] ch , int i ,int j){
        char temp = ch[i];
        ch[i]=ch[j];
        ch[j]=temp;
    }
}
