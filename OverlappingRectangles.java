public class OverlappingRectangles {
    int doOverlap(int l1[], int r1[], int l2[], int r2[]) {
        // code here
        if(r2[0]<l1[0]||l2[0]>r1[0]||l2[1]<r1[1]||r2[1]>l1[1] ){
            return 0;
        }
        
        return 1;
    }
}
