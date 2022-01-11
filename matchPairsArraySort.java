import java.util.*;
public class matchPairsArraySort {
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        Character[] Nuts = new Character[n];
        for(int i=0;i<nuts.length;i++){
            Nuts[i]=nuts[i];
        }
        Arrays.sort(Nuts , new Comparator<Character>(){
            @Override
            public int compare(Character a , Character b){
                HashMap<Character , Integer> hm = orderHM();
                return hm.get(b)-hm.get(a);
            }
        } );
        Character[] Bolts = new Character[n];
        for(int i=0;i<bolts.length;i++){
            Bolts[i]=bolts[i];
        }
        
        for(int i=0;i<nuts.length;i++){
            nuts[i]=Nuts[i];
        }
        Arrays.sort(Bolts , new Comparator<Character>(){
            @Override
            public int compare(Character a , Character b){
                HashMap<Character , Integer> hm = orderHM();
                return (int)(hm.get(b)-hm.get(a));
            }
        } );
        
        for(int i=0;i<bolts.length;i++){
            bolts[i]=Bolts[i];
        }
        
        return ;
        
        
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

//Initial Template for Java




