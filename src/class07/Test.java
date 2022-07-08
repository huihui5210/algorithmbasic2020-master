package class07;

public class Test {
   static class  Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
       node.next.next = new Node(3);

       node.next = node.next.next;
//       node = node.next;
       System.out.println(node.value);
       System.out.println(node.next.value);
    }
}
