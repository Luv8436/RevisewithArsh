public class Winnerofanelection {
    public static String[] winner(String arr[], int n)
    {
        // add your code
        HashMap<String,Integer> count = new HashMap<>();
        for(int i=0;i<n;i++){
            if(count.containsKey(arr[i])){
                count.put(arr[i],count.get(arr[i] )+1 );
            }else{
                count.put(arr[i],1 );
            }
        }
        
        int max = 0;
        String maxName="";
        for(String name: count.keySet() ){
            if(count.get(name)>max){
                max=count.get(name);
                maxName=name;
            }else if(count.get(name)==max){
                if(maxName.compareTo(name)>0){
                    maxName=name;
                }
            }
        }
        
        String[] ans = new String[2];
        ans[0]=maxName;
        ans[1]=""+max;
        return ans;
    } 
}
