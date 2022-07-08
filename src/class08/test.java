package class08;

public class test {
    private  static  Node1 root;
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            pass = 0;
            end = 0;
            nexts = new Node1[26];
        }
    }

    public static void main(String[] args) {
        Node1 node1 = new Node1();
        System.out.println(node1.nexts[1] == null);
        Node1 head = root;
        System.out.println(head == null);
    }

}
