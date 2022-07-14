package class03;

import java.util.ArrayList;

public class Code04_RingArray {
	//数组实现环形数组
	// 注意  数从尾加，从头取。
	// 数组： int[]
	// 队列： arraylist
	public static class MyRingArrayTest{
		int length;
		int head =0;
		int tail =0;
		int cur =0;
		int[] ints ;
		public MyRingArrayTest(int length) {
			this.length = length;
			this.ints = new int[length];
		}
		public void add(int num){
			if (cur >= length ){
				System.out.println("溢出来了");
				return;
			}
			cur++;
			ints[tail] = num; //这地方需要直接替换！ 不是添加！
			tail = (tail+1) % length;
		}
		public Integer pop(){
			if (cur == 0){
				System.out.println("空了");
				return -1;
			}
			cur--;
			int ans= ints[head];
			head = (head+1)%length;
			return ans;
		}

		public static void main(String[] args) {
			MyRingArrayTest myRingArrayTest = new MyRingArrayTest(6);
			myRingArrayTest.add(1);
			myRingArrayTest.add(2);
			myRingArrayTest.add(3);
			myRingArrayTest.add(4);
			myRingArrayTest.add(5);
			myRingArrayTest.add(6);
			myRingArrayTest.add(7);
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			myRingArrayTest.add(7);
			myRingArrayTest.add(8);
			myRingArrayTest.add(9);
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());
			System.out.println(myRingArrayTest.pop());


		}



	}



	//数组实现栈
	public static class MyStackTest{

		int  n ;
		private int[] arr;
		int index = 0;

		public MyStackTest(int n) {
			arr = new int[n];
			this.n = n;
		}
		public void push(int num){
			if (index>=n){
				System.out.println("溢出");
				return;
			}
			arr[index++] = num;
		}
		public int pop(){
			if (index <=0){
				System.out.println("空了");
				return -1;
			}
			return arr[--index];
		}
	}

	public static void main(String[] args) {
		MyStackTest myStackTest = new MyStackTest(5);
		myStackTest.push(1);
		myStackTest.push(2);
		myStackTest.push(3);
		myStackTest.push(4);
		System.out.println(myStackTest.pop());
		System.out.println(myStackTest.pop());
		System.out.println(myStackTest.pop());
		System.out.println(myStackTest.pop());
		System.out.println(myStackTest.pop());
		ArrayList<Integer> arrayList = new ArrayList<>();

	}
	public static class MyQueue {
		private int[] arr;
		private int pushi;// end
		private int polli;// begin
		private int size;
		private final int limit;

		public MyQueue(int limit) {
			arr = new int[limit];
			pushi = 0;
			polli = 0;
			size = 0;
			this.limit = limit;
		}

		public void push(int value) {
			if (size == limit) {
				throw new RuntimeException("队列满了，不能再加了");
			}
			size++;
			arr[pushi] = value;
			pushi = nextIndex(pushi);
		}

		public int pop() {
			if (size == 0) {
				throw new RuntimeException("队列空了，不能再拿了");
			}
			size--;
			int ans = arr[polli];
			polli = nextIndex(polli);
			return ans;
		}

		public boolean isEmpty() {
			return size == 0;
		}

		// 如果现在的下标是i，返回下一个位置
		private int nextIndex(int i) {
			return i < limit - 1 ? i + 1 : 0;
		}

	}


}
