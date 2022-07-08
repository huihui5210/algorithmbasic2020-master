package class12;

public class PracticeIsCBT {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static class  Info{
        public boolean isCBT;
        public boolean isFull;
        public int height;

        public Info(boolean isCBT, boolean isFull, int height) {
            this.isCBT = isCBT;
            this.isFull = isFull;
            this.height = height;
        }
    }

    public static boolean isCBT(Node head) {
        if (head == null){return false;}
        Info info = process(head);
        return  info.isCBT;
    }

    public static Info process(Node head){
        if (head == null){
            return  new Info(true,true,0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int height = Math.max(left.height,right.height) +1;
        if (left.isFull && right.isFull){
            if (left.height == right.height  ){
                return new Info(true,true,height);
            }
            if (left.height - right.height ==1 ){
                return new Info(true,false,height);
            }
        }
        if (left.isFull && right.isCBT){
            if (left.height - right.height == 1){
                return new Info(true,false,height);
            }
        }
        if (left.isCBT && right.isFull){
            if (left.height - right.height == 1){
                return new Info(true,false,height);
            }
        }
        return new Info(false,false ,height);
    }
}
