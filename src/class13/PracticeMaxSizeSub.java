package class13;

public class PracticeMaxSizeSub {
    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node(int data) {
            this.value = data;
        }
    }
    public static class Info{
        public int maxSubSizes;
        public int size;
        public int max;
        public int min;

        public Info(int maxSubSizes, int size, int max, int min) {
            this.maxSubSizes = maxSubSizes;
            this.size = size;
            this.max = max;
            this.min = min;
        }
    }

    public static int maxSubSize(Node head){
        if (head == null){
            return 0;
        }
        Info help = process(head);
        return help.maxSubSizes;
    }

    public static Info process(Node head){
        //由于BST的根部需要比较，所以简单处理
        if (head == null){return  null;}
        Info left = process(head.left);
        Info right = process(head.right);
        //更新max
        int max = 0;
        int min = 0;
        int size = 1 ;
        if (left !=null ){
            max = Math.max(max,left.max);
            min = Math.min(min,left.min);
            size +=left.size;
        }
        if (right !=null ){
            max = Math.max(max,right.max);
            min = Math.min(min,right.min);
            size +=right.size;
        }
        max = Math.max(max,head.value);
        min = Math.min(min,head.value);
        int p1 = -1;
        if (left != null){
            p1 = left.maxSubSizes;
        }
        int p2 = -1;
        if (right !=null){
            p2 = right.maxSubSizes;
        }
        int p3 = -1;
        // 空值的处理
        boolean leftIsBST = left == null ? true: (left.maxSubSizes == left.size);
        boolean rightIsBST = right == null ? true: (right.maxSubSizes == right.size);
        if (leftIsBST&& rightIsBST ){
            boolean leftMaxLessX = left==null ? true: (left.max <= head.value);
            boolean rightMaxMoreX = right==null ? true: (right.min >= head.value);
            if (leftMaxLessX && rightMaxMoreX){ //说明就是BST
                int leftSize = left == null ? 0: left.size;
                int rightSize = right == null ? 0: right.size;
                p3 = leftSize + rightSize + 1;
            }
        }
        return new Info(Math.max(p1,Math.max(p2,p3)),size , max,min);
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.left = new Node(1);
        head.right = new Node(3);
        System.out.println(maxSubSize(head));
    }
}
