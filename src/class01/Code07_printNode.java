package class01;

import java.util.LinkedList;

public class Code07_printNode {
     static class Node{
        public int num;
        public Node next;

        public Node(int num) {
            this.num = num;
        }
    }

    public static void main(String[] args) {
//        LinkedList<Node> linkedList = new LinkedList<>();
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        Node cur = head;
//        linkedList.add(head);
//        linkedList.get(1);
        while (cur!=null){
            System.out.println(cur.num);
            cur=cur.next;
        }
        System.out.println();
    }
}
