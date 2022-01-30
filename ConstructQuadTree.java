public class ConstructQuadTree {
    public Node construct(int[][] grid) {
        int n = grid.length;
        return quadTree(grid,0,n-1,0,n-1);
    }
    static Node quadTree(int[][] grid,int minRow,int maxRow,int minCol,int maxCol){
        if(minRow==maxRow&&minCol==maxCol){
            Node root = new Node(grid[minRow][minCol]==0?false:true , true);
            return root;
        }
        int value=grid[minRow][minCol];
        for(int row=minRow;row<=maxRow;row++){
            for(int col=minCol;col<=maxCol;col++){
                if(grid[row][col]!=value){
                    Node root = new Node(false,false);
                    int midRow = (maxRow+minRow)/2;
                    int midCol = (maxCol+minCol)/2;
                    root.topLeft = quadTree(grid,minRow,midRow,minCol,midCol);
                    root.topRight = quadTree(grid,minRow,midRow,midCol+1,maxCol);
                    root.bottomLeft = quadTree(grid,midRow+1,maxRow,minCol,midCol);
                    root.bottomRight = quadTree(grid,midRow+1,maxRow,midCol+1,maxCol);
                    return root;
                }
            }
        }
        
        Node root = new Node(value==0?false:true,true);
        return root;
    }
}

class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};