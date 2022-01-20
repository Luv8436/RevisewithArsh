import java.util.*;
public class ConnectNodesatSameLevel {
    //Function to connect nodes at same level.
    public void connect(Node root)
    {
        // Your code goes here.
        ArrayList<Node> al = new ArrayList<>();
        connect(root,0,al);
    }
    static void connect(Node root,int depth,ArrayList<Node> nodes){
        if(root==null){
            return ;
        }
        
        if(depth==nodes.size()){
            root.nextRight = null;
            nodes.add(root);
        }else{
            root.nextRight = nodes.get(depth);
            nodes.set(depth,root);
        }
        
        
        connect(root.right,depth+1,nodes);
        connect(root.left ,depth+1,nodes);
        
        return ;
    }
}

class Node{
    int data;
    Node left;
    Node right;
    Node nextRight;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
        nextRight = null;
    }
}