package JavaTest;

public class ReverseNode {
    public static class Node{
        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
        }
    }
    public static Node reverseNode(Node head){
        Node pre = null;
        Node cur = head;
        Node next = null;
        while (cur!=null){
            next  =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return  pre;
    }

    public static void main(String[] args) {
        Node head = new  Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        Node ans = reverseNode(head);
        while (ans!=null){
            System.out.println(ans.value);
            ans = ans.next;
        }
    }
}
