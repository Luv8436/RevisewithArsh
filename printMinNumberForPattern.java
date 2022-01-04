public class printMinNumberForPattern {
    static String MinNumberForPattern(String s){
        // code here
        int[] arr = new int[s.length()+1];
        int counter=1;
        for(int index=0;index<s.length();index++){
            char ch = s.charAt(index);
            if(ch=='I'){
                int tindex=index;
                while(tindex>=0&&arr[tindex]==0){
                    arr[tindex--]=counter++;
                }
            }
        }
        int index=arr.length-1;
        while(index>=0&&arr[index]==0){
            arr[index]=counter++;
            index--;
        }
        
        String ans = "";
        for(int i=0;i<arr.length;i++){
            ans+=arr[i];
        }
        
        return ans;
    }
}
