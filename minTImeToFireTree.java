import java.util.*;
public class minTImeToFireTree {
    class Node {
    	int data;
    	Node left;
    	Node right;
    
    	Node(int data) {
    		this.data = data;
    		left = null;
    		right = null;
    	}
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        ArrayList<Node> path = nodeToRootPath(root , target);
        int max = 0;
        // for(Node node:path){
        //     System.out.print(node.data + " ");
        // }
        Node blocker = null;
        int index=0;
        while(index<path.size() ){
            int h = maxHeight(path.get(index) , blocker );
            int temp = index+h-1;
            if(temp>max){
                max = temp;
            }
            blocker = path.get(index);
            index++;
        }
        
        return max;
    }
    
    public static int maxHeight(Node root , Node blocker){
        if(root==blocker||root==null ){
            return 0;
        }
        

        int left = maxHeight(root.left,blocker);
        int right = maxHeight(root.right,blocker);

        return 1 + Integer.max(left, right);
    }
    
    public static ArrayList<Node> nodeToRootPath(Node root , int target){
        if(root==null){
            return new ArrayList<>();
        }else if(root.data==target){
            ArrayList<Node> ans = new ArrayList<>();
            ans.add(root);
            return ans;
        }
        
        ArrayList<Node> left = nodeToRootPath(root.left , target);
        if(left.size()>0){
            left.add(root);
            return left;
        }
        
        ArrayList<Node> right = nodeToRootPath(root.right , target);
        if(right.size()>0 ){
            right.add(root); 
        }
        return right;
    } 
}
