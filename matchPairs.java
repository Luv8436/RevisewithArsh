import java.util.*;
public class matchPairs {
    void matchPairsQuickSort(char nuts[], char bolts[], int n) {
        HashMap<Character , Integer> hm= orderHM();
        quickSort(nuts , 0 , nuts.length-1 , hm);
        quickSort(bolts , 0 , bolts.length-1 , hm);
    }
    
    public static void quickSort(char[] arr,int l,int r,HashMap<Character , Integer> hm){
        if(l>=r){
            return ;
        }
        int pi = partitioning(arr,l,r,arr[r],hm);
        quickSort(arr,l,pi-1,hm);
        quickSort(arr,pi,r,hm);
    }
    public static int partitioning(char[] arr , int l,int r,char pivot,HashMap<Character , Integer> hm){
        int known=l;
        int unknown=l;
        while(unknown<=r){
            // unknown>pivot
            if( hm.get(arr[unknown])<hm.get(pivot) ){
                unknown++;
            }else{
                char temp = arr[known];
                arr[known] = arr[unknown];
                arr[unknown] = temp;
                unknown++;
                known++;
            }
        }
        return known-1;
    }
    
    public static HashMap<Character , Integer> orderHM(){
        HashMap<Character , Integer> hm = new HashMap<>();
        hm.put('!' , 9);
        hm.put('#' , 8);
        hm.put('$' , 7);
        hm.put('%' , 6);
        hm.put('&' , 5);
        hm.put('*' , 4);
        hm.put('@' , 3);
        hm.put('^' , 2);
        hm.put('~' , 1);
        return hm;
    }
}
