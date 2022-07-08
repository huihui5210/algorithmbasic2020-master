package class10;

public class practiceFirstInNode {
    public static class Node {
        public int value;
        public Node next;

        public Node(int v) {
            value = v;
        }
    }

    //找到第一个点
    public static Node getIntersectNode(Node head1, Node head2) {
        //先找入环点
        Node loop1 = getLoop(head1);
        Node loop2 = getLoop(head2);
        if (loop1 == null && loop2 == null) {
            return getNoneLoop(head1, head2);
        }
        if ((loop1 != null && loop2 == null) || (loop1 == null && loop2 != null)) {
            return null;
        }
//    //有环的3种情况
    if (loop1==loop2){
        Node cur1 = head1;
        Node cur2 = head2;
        int len1 = 1;
        int len2 = 1;
        while (cur1!=loop1){
            cur1 = cur1.next;
            len1++;
        }
        while (cur2!=loop1){
            cur2 = cur2.next;
            len2++;
        }
        if (len1 >=len2){
            int rest = len1 - len2;
            Node cur = head1;
            while ( rest!=0){
                cur = cur.next;
                rest--;
            }
            return cur;
        }else{
            int rest = len2 - len1;
            Node cur = head2;
            while ( rest!=0){
                cur = cur.next;
                rest--;
            }
            return cur;
        }
    }   else{
        return  getNodeLoop(head1,head2,loop1,loop2);
    }
    }

    public static Node getNodeLoop(Node head1,Node head2 , Node loop1 ,Node loop2){
        Node temp = loop1;
        while (temp!=loop2){
            temp = temp.next;
            if (temp==loop1){return null;}
        }
        return loop1;
    }

    public static Node getNoneLoop(Node head1,Node head2){
        int len1 = 1;
        int len2 = 1;
        Node cur1 = head1;
        Node pre1 = head1;
        Node cur2 = head2;
        Node pre2 = head2;
        while (cur1!=null){
            pre1 = cur1;
            cur1 = cur1.next;
            len1++;
        }
        while (cur2!=null){
            pre2 = cur2;
            cur2 = cur2.next;
            len2++;
        }
        if (pre1 != pre2){
            return  null;
        }
        if (len1 >= len2){
            int rest = len1 - len2;
            Node cur =head1;
             cur2 =head2;
            while (rest>0){
                cur= cur.next;
                rest--;
            }
           while (cur!=cur2){
               cur = cur.next;
               cur2 = cur2.next;
           }
            return cur;
        }else{
            int rest = len2 - len1;
            Node cur =head2;
            cur1 =head1;
            while (rest-->=0){
                cur= cur.next;
            }
            while (cur!=cur1){
                cur = cur.next;
                cur1 = cur1.next;
            }
            return cur;
        }
    }


    public static Node getLoop(Node head){
        Node quick = head;
        Node slow = head;
         while (quick.next!= null && slow !=null ){
            quick = quick.next.next;
            slow = slow.next;
            if (quick == slow){break;}
        }
        if (quick == null || quick.next ==null){
            return  null;
        }
        quick = head;
        while (quick != slow){
            quick = quick.next;
            slow = slow.next;
        }
        return  slow;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        head1.next.next.next.next.next = new Node(6);
        head1.next.next.next.next.next.next = new Node(7);
        head1.next.next.next.next.next.next.next = head1.next.next.next.next;

        // 0->9->8->6->7->null
        Node head2 = new Node(0);
        head2.next = new Node(9);
        head2.next.next = new Node(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        Node loop1 = getLoop(head1);
//        System.out.println(loop1.value);
        Node loop2 = getLoop(head2);
//        System.out.println(loop2.value);
     Node ans =   getIntersectNode(head1,head2);
        System.out.println(ans.value);
    }
}
