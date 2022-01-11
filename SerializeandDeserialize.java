import java.util.*;
public class SerializeandDeserialize {
    public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    if(root==null){
	        A.add(null);
	        return ;
	    }
	    A.add(root.data);
	    serialize(root.left,A);
	    serialize(root.right,A);
	}
	
	//Function to deserialize a list and construct the tree.
	public static int index;
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        index=0;
        return deSerializeHelper(A);
    }
    public static Node deSerializeHelper(ArrayList<Integer> al){
        Integer i = al.get(index++);
        if(i==null){
            return null;
        }
        Node root = new Node(i);
        root.left = deSerializeHelper(al);
        root.right = deSerializeHelper(al);
        
        
        return root;
        
    }
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left=null;
            right=null;
        }
    }
}
