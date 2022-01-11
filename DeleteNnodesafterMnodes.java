
public class DeleteNnodesafterMnodes {
    class Node {
    	int data;
    	Node next;
    
    	Node(int data) {
    		this.data = data;
    		this.next = null;
    	}
    }
    public static void linkdelete(Node head, int M, int N)
    {
        // your code here
        Node temp = head;
        int count=1;
        while(temp!=null&&count<M ){
            temp=temp.next;
            count++;
        }
        if(temp==null||temp.next==null){
            return ;
        }
        
        Node ptr = temp.next;
        count=1;
        while(ptr!=null&&count<=N){
            ptr=ptr.next;
            count++;
        }
        temp.next = ptr;
        linkdelete(ptr , M , N);
    }
}
