package class11;

import class10.Code02_RecursiveTraversalBT;

public class testNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int v) {
            value = v;
        }
    }
    public static  String pres2(Node head){
        if (head == null){
            return  "null";
        }
        String left =pres2(head.left);
        String right =pres2(head.right);
        return    left+","+ String.valueOf(head.value)+","+ right;
    }
    public static  String pres3(Node head){
        if (head == null){
            return  "null";
        }
        String left =pres3(head.left);
        String right =pres3(head.right);
        return  left +","+ right +","+String.valueOf(head.value) ;
    }
    public static  String pres1(Node head){
        if (head == null){
            return  "null";
        }
        String left =pres1(head.left);
        String right =pres1(head.right);
        return  String.valueOf(head.value) +","+ left +","+ right;
    }

    public static void main(String[] args) {
         Node head = new Node(1);
         head.left = new Node(2);
         head.right = new Node(5);
         head.left.left = new Node(3);
         head.left.right = new Node(4);
         head.right.left = new Node(6);
        System.out.println(pres1(head));
        System.out.println(pres2(head));
        System.out.println(pres3(head));
    }
}
