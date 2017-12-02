package ctci.chapter4.treeandgraph;


public class MinimalTree {

    private class Node{
        public int value;
        public Node left;
        public Node right;

        public Node(int value){
            this.value = value;
        }
    }

    public Node createBinarySearchTree(int[] sortedArray, int start, int end){
        if(start > end){
            return null;
        }
        int mid = (start + end) >>> 1;
        Node child = new Node(sortedArray[mid]);
        System.out.printf("create node:%d \n",child.value);
        child.left = createBinarySearchTree(sortedArray, start,mid-1);
        child.right = createBinarySearchTree(sortedArray,mid+1, end);

        return child;
    }

    public void inOrderTravel(Node node){
        if(node == null){
            return;
        }

        if(node.left != null){
            inOrderTravel(node.left);
        }
        System.out.printf("%d ", node.value);
        if(node.right != null){
            inOrderTravel(node.right);
        }
    }


    public static void main(String[] args) {
        int[] sortedArray = new int[]{0,1,2,3,4,5,6,7,8,9};
        MinimalTree mTree = new MinimalTree();
        Node root = mTree.createBinarySearchTree(sortedArray,0,9);

        //pre-Order travel
        mTree.inOrderTravel(root);
    }


}
