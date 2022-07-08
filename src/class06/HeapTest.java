package class06;

import java.util.PriorityQueue;

public class HeapTest {
    public static void main(String[] args) {
        //小根堆 小的数在堆顶
        //poll
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);
        heap.add(4);
        heap.add(5);
        heap.add(6);

        System.out.println(heap.poll());
        for (Integer i : heap){
            System.out.println(i);
        }
        System.out.println( );
        PriorityQueue<Integer> heap2 = new PriorityQueue<>((o1, o2) ->{return  o2-o1;} );
        heap2.add(1);
        heap2.add(2);
        heap2.add(3);
        heap2.add(5);
        heap2.add(4);
        heap2.add(6);
       //如何实现更换位置呢？ 应该可以不用heap中自己实现， 需要用一个hashMap 做反向表
        System.out.println(heap2.poll());
        for (Integer i : heap2){
            System.out.println(i);     //按照的是数组的存储顺序
        }

    }
}
