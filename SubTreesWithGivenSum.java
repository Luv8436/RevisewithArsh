public class SubTreesWithGivenSum {
    //Function to count number of subtrees having sum equal to given sum.
    static int count;
    int countSubtreesWithSumX(Node root, int X)
    {
        count = 0;
        countHelper(root,X);
        return count;
    }
    static int countHelper(Node root,int X){
        if(root==null) return 0;
        int leftSum = countHelper(root.left,X);
        int rightSum = countHelper(root.right,X);
        
        int treeSum = root.data+leftSum+rightSum;
        if(treeSum==X) count++;
        
        return treeSum;
        
    }
}
