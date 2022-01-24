public class nextHigherNumWithSameDIgits {
    public String nextPalin(String s) 
    { 
        //complete the function here
        int n = s.length();
        if(n<=1){
            return "-1";
        }
        String half = s.substring(0,n/2);
        String left = nextGreater(half);
        if(left.length()==0){
            return "-1";
        }
        
        StringBuilder temp = new StringBuilder(left);
        temp=temp.reverse();
        String right = temp.toString();
        if(n%2==0){
            return left+right;
        }
        return left+s.charAt(n/2)+right;
    }
    static String nextGreater(String s){
        if(s.length()<=1 ){
            return "";
        }
        
        char[] arr = s.toCharArray();
        int index=arr.length-1;
        while(index>0){
            if(arr[index-1]<arr[index]){
                int j=arr.length-1;
                while(arr[j]<=arr[index-1]){
                    j--;
                }
                char temp = arr[index-1];
                arr[index-1]=arr[j];
                arr[j]=temp;
                Arrays.sort(arr,index,arr.length);
                return new String(arr);
            }
            index--;
        }
        
        return "";
    }
}
