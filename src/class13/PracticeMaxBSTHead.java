//package class13;
//
//public class PracticeMaxBSTHead {
//    public static class Node {
//        public int value;
//        public Node left;
//        public Node right;
//        public Node(int data) {
//            this.value = data;
//        }
//    }
//    public static class Info{
//        public int headNum;
//        public int max;
//        public int min;
//        public boolean isBST;
//        public int size;
//        public Info(int headNum, int max, int min, boolean isBST,int size) {
//            this.headNum = headNum;
//            this.max = max;
//            this.min = min;
//            this.isBST = isBST;
//            this.size = size;
//        }
//    }
//    public static int maxNum(Node head){
//        if (head == null){return -1;}
//        Info help = process(head);
//        return help.headNum;
//    }
//    public static Info process(Node head){
//        if (head == null){
//            return null;
//        }
//        Info left = process(head.left);
//        Info right = process(head.right);
//        boolean isBST = true;
//        if (left!=null && !left.isBST ){
//            isBST = false;
//        }
//        if (right!=null && !right.isBST ){
//            isBST = false;
//        }
//        if ( (left!=null && left.max > head.value) || (right!=null &&right.min<head.value) ){
//            isBST = false;
//        }
//        int max = 0;
//        int min = 0;
//        if (left!=null){
//            max = Math.max(max ,left.max);
//            min = Math.min(min,left.min);
//        }
//        if (right!=null){
//            max = Math.max(max,right.max);
//            min = Math.min(min,right.min);
//        }
//        max = Math.max(max,head.value);
//        min = Math.min(min,head.value);
//        int headNum = 0;
//        if (isBST ){headNum = head.value;}
//        if (!isBST && left.)
//    }
//
//}
