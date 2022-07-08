package class13;

public class PracticeMaxDIstense {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    //max是x节点的最大距离 （可能是与x有关，可能无关）
    public static class Info{
        public int max;
        public int height;

        public Info(int max, int height) {
            this.max = max;
            this.height = height;
        }
    }

    public static  int maxDistance(Node head){
        if (head==null){
            return  0;
        }
        Info help = process(head);
        return help.max;
    }
        public static Info process(Node head){
        if (head == null){
            return new Info(0,0);
        }
        Info left = process(head.left);
        Info right = process(head.right);
        int height = Math.max(left.height,right.height)+1;
        int max = 0;
        int temp = Math.max(left.max , right.max);
        max = temp>= (left.height + 1 + right.height) ? temp : (left.height + 1 + right.height);
        return new Info(max,height);
}
}
