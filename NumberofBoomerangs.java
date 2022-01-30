public class NumberofBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        
        int count=0;
        int n = points.length;
        for(int i=0;i<n;i++){
            HashMap<Double,Integer> hm = new HashMap<>();
            for(int j=0;j<n;j++){
                if(i==j) continue;
                double distance = dist(points,i,j);
                if(hm.containsKey(distance) ){
                    hm.put(distance , hm.get(distance)+1 );
                }else{
                    hm.put(distance , 1);
                }
            }
            for(double distance : hm.keySet() ){
                int val = hm.get(distance);
                if(val>=2){
                    count+=(val*(val-1));
                }
            }
        }
        
        return count;
    }
    static double dist(int[][] points,int i,int j ){
        return Math.sqrt( (points[i][0]-points[j][0] )*(points[i][0]-points[j][0] ) + (points[i][1]-points[j][1] )*(points[i][1]-points[j][1] )  );
    }
}
