import java.util.*;
public class PossibleWordsPhoneDigits {
    //Function to find list of all words possible by pressing given numbers.
    static ArrayList <String> possibleWords(int a[], int N)
    {
        // your code here
        String[] words = {"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        return possibleWords(a,0,words);
        
    }
    static ArrayList <String> possibleWords(int arr[], int index,String[] words){
        if(index==arr.length){
            ArrayList<String> ans = new ArrayList<String>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String> ans = possibleWords(arr,index+1,words);
        if(words[arr[index]-1].length()==0){
            return ans;
        }
        ArrayList<String> fans = new ArrayList<>();
        for(int i=0;i<words[arr[index]-1].length();i++ ){
            char ch = words[arr[index]-1].charAt(i);
            for(String word: ans){
                fans.add(ch+word);
            }
        }
        
        return fans;
    }
}
