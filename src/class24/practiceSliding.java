package class24;

import java.util.ArrayDeque;

public class practiceSliding {
    public static void getMaxWindow(int[] arr, int w) {
        //给的长度是w
        // base case

        int[] ans = new  int[arr.length - w + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int L = 0;
        int R = w-1;
        queue.push(arr[0]);
        for (int i = 0; i< w;i++){
            if (arr[i]< queue.peek()){
                queue.add(i);
            }else{
                queue.pollFirst();
                queue.add(i);
            }
        }
        while (R<arr.length) {
            if (L + w - 1 > R) {
                R++;
            } else {
                System.out.print(arr[queue.peek()]);
                if (L >= queue.peek()) {
                    queue.poll();
                }
                L++;
                R++;
                while (!queue.isEmpty() && R < arr.length && arr[queue.getLast()] <= arr[R]) {
                    queue.pollLast();
                }
                queue.addLast(R);
            }
        }
    }
    public static void getMaxWindow2(int[] arr, int w) {
        //base case
        int R = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        while (R<arr.length){
            while (!queue.isEmpty()&& arr[R]>=arr[queue.peek()]){
                queue.pollFirst();
            }
            queue.add(R);
            if (R-w+1>=0){
                System.out.println(arr[queue.peek()]);
            }
            R++;
            if (R-w == queue.peek()){
                queue.pollFirst();
            }
        }


    }


    public static void main(String[] args) {
        int[] arr = new int[]{4,3,5,4,6};
        getMaxWindow(arr,3);
        System.out.println();
        getMaxWindow2(arr,3);
    }
}
