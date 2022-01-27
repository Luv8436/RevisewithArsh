public class FindMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        return search(mountainArr,target,0,mountainArr.length()-1 );
    }
    static int search(MountainArray arr,int target,int l,int r){
        if(l>r){
            return -1;
        }
        int index = (l+r)/2;
        int mid = arr.get(index);
        int left=0,right=0;
        if(index!=0)
        left = arr.get(index-1);
        if(index!=arr.length()-1)
        right = arr.get(index+1);
        
        if(mid>left&&mid>right){
            // mid is peak
            if(target>mid){
                return -1;
            }
            int ans = search(arr,target,l,index-1);
            if(ans!=-1) return ans;
            if(mid==target) return index;
            ans = search(arr,target,index+1,r);
            if(ans!=-1) return ans;
        }else if(index==0|| (mid>left&&mid<right) ){
            // left side of peak
            if(target>mid){
                return search(arr,target,index+1,r);
            }
            int ans = search(arr,target,l,index-1);
            if(ans!=-1) return ans;
            if(mid==target) return index;
            ans = search(arr,target,index+1,r);
            if(ans!=-1) return ans;
        }else if((index==arr.length()-1)|| mid<left&&mid>right){
            // right side of peak
            if(target>mid){
                return search(arr,target,l,index-1);
            }
            int ans = search(arr,target,l,index-1);
            if(ans!=-1) return ans;
            if(mid==target) return index;
            ans = search(arr,target,index+1,r);
            if(ans!=-1) return ans;
        }
        
        return -1;
    }
}
