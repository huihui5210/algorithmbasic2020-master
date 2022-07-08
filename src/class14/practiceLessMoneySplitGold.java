package class14;

import java.util.PriorityQueue;

public class practiceLessMoneySplitGold {
    public static int lessMoney2(int[] arr) {
        if (arr.length == 0){
            return  0;
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : arr){
            priorityQueue.add(num);
        }
        int ans  = 0;
        while (priorityQueue.size() != 1){
            int min = priorityQueue.poll();
            int min2 = priorityQueue.poll();
            int temp = min + min2;
            ans += temp;
            priorityQueue.add(temp);
        }
        ans +=priorityQueue.poll();
        return ans;
    }

    public static void main(String[] args) {

    }
}
