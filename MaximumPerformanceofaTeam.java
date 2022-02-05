public class MaximumPerformanceofaTeam {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        Pair[] arr = new Pair[n];
        for(int i=0;i<n;i++){
            arr[i] = new Pair(speed[i],efficiency[i]);
        }
        
        Arrays.sort(arr, (a,b) -> b.eff-a.eff );
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, (a,b) -> a.speed-b.speed );
        long maxPerformance = speed[0]*efficiency[0];
        long sumOfSpeed = 0;
        for(int i=0;i<n;i++){
            pq.add(arr[i]);
            sumOfSpeed+=arr[i].speed;
            if(pq.size()>k ) sumOfSpeed-=pq.poll().speed;
            maxPerformance = Math.max(maxPerformance, arr[i].eff*sumOfSpeed );
        }
        
        return (int) (maxPerformance % (long)(1e9 + 7));
    }
    static class Pair{
        int speed;
        int eff;
        Pair(int speed,int eff){
            this.speed=speed;
            this.eff=eff;
        }
    }
}
