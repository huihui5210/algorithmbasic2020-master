package class12;

public class PracticeIsFull {
    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static  class Info{
        public int count ;
        public int height ;
        public boolean isFull;
        public Info(int count, int height,boolean isFull) {
            this.count = count;
            this.height = height;
            this.isFull = isFull;
        }
    }

    public static boolean isFull(Node head){
        if (head == null){return false;}
        Info info = process(head);
        return  info.isFull;
    }
    public  static Info process(Node head){
        if (head == null){
            return  new Info(0,0,true);
        }
        Info left  = process(head.left);
        Info right  = process(head.right);
        int height =  Math.max(left.height,right.height) +1;
        int count =  left.count + right.count+1;
        boolean isFull = left.isFull && right.isFull && (count == Math.pow(2,height)-1);
        return new Info(count,height,isFull);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        boolean full = isFull(head);
        System.out.println(full);
    }
}
