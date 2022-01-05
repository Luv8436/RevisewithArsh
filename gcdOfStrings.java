public class gcdOfStrings {
    public String gcdOfStringsSolution(String str1, String str2) {
        if(str1.length()<str2.length() ){
            return gcdOfStringsSolution(str2 , str1);
        }
        
        if(str2.length()==0){
            return str1;
        }
        
        if(!str1.substring(0, str2.length() ).equals(str2) ){
            return "";
        }
        
        return gcdOfStringsSolution(str1.substring(str2.length() ) , str2 );
    }
}
