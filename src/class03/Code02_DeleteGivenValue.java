package class03;

public class Code02_DeleteGivenValue {

	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// head = removeValue(head, 2);
	public static Node removeValueMy(Node head, int num) {
		while (head != null){
			if (head.value != num){
				break;
			}
			head = head.next;
		}
		//现在cur不是num
		Node cur = head;
		Node pre = head;
//		Node next= head.next; 不能确保非空
		while ( cur != null){
			if (cur.value == num){
				pre.next = cur.next;
			}else{
			pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}


	public static Node removeValue(Node head, int num) {
		// head来到第一个不需要删的位置
		while (head != null) {
			if (head.value != num) {
				break;
			}
			head = head.next;
		}
		// 1 ) head == null
		// 2 ) head != null
		Node pre = head;
		Node cur = head;
		while (cur != null) {
			if (cur.value == num) {
				pre.next = cur.next;
			} else {
				pre = cur;
			}
			cur = cur.next;
		}
		return head;
	}

	public static void main(String[] args) {
		Node head = new  Node(1);
		head.next = new Node(2);
		head.next.next = new Node(2);
		head.next.next.next = new Node(2);
		Node cur =removeValueMy(head, 2);
		while (cur!=null){
			System.out.println(cur.value);
			cur = cur.next;
		}
	}
}
