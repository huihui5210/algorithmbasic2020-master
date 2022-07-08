package class12;

public class PracticeISBST {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class Info{
        public int height;
        public boolean isBST;

        public Info(int height, boolean isBST) {
            this.height = height;
            this.isBST = isBST;
        }
    }


    public static boolean isBST1(Node head) {
        if (head == null){
            return  false;
        }
        Info  info=process(head);
        return  info.isBST;
    }

    public static Info process(Node head){
        if (head == null){
            Info info = new Info(0,true);
            return info;
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int height =  Math.max(left.height,right.height) +1;
        boolean isBST = left.isBST && right.isBST && ( Math.abs(left.height -right.height) <=1);
        return  new Info(height,isBST);
    }


    public static void main(String[] args) {

    }
}
