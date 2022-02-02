public class TransformtoSumTree {
    public void toSumTree(Node root){
        //add code here.
        helper(root);
   }
   static int helper(Node root){
       if(root==null) return 0;
       
       int left = helper(root.left);
       int right = helper(root.right);
       
       int sum = left+right+root.data;
       root.data = left+right;
       
       return sum;
   }
}
class Node{
    int data;
    Node left,right;
    Node(int d){
    	data=d;
    	left=null;
    	right=null;
    }
}