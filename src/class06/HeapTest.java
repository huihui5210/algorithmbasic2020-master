//package class06;
//
//
//
//import java.util.Collection;
//import java.util.Comparator;
//import java.util.PriorityQueue;
//import java.util.SortedSet;
//
//public class HeapTest {
//    static class StudentComparator implements Comparator<Integer> {
//        @Override
//        public int compare( Integer o1,Integer o2) {
//            return Integer.compare(o1,o2);
//        }
//    static class Student{
//        int id;
//        String name;
//
//        public Student() {
//        }
//
//        public Student(int id) {
//            this.id = id;
//        }
//
//        @Override
//        public String toString() {
//            return "Student{" +
//                    "id=" + id +
//                    '}';
//        }
//    }
//    public static void main(String[] args) {
//        //小根堆 小的数在堆顶
//        //poll
//        Student student0 = new Student(1);
//        Student student1 = new Student(2);
//        Student student2 = new Student(3);
//        Student student3 = new Student(4);
//        PriorityQueue<Student> heap = new PriorityQueue<>( (o1, o2) ->  Integer.compare(o1.id,o2.id)) ;
////        PriorityQueue<Student> heap = new PriorityQueue<>( new StudentComparator()) ;
//        PriorityQueue<Integer> heap2 = new PriorityQueue<>( new StudentComparator()) ;
//        heap.add(student0);
//        heap.add(student1);
//        heap.add(student2);
//        heap.add(student3);
//        heap.add(student0);
////        for (Student i : heap){
////            System.out.println(i);
////        }
//        System.out.println(heap.poll());
//        System.out.println(heap.poll());
//        System.out.println(heap.poll());
//        System.out.println(heap.poll());
//
////        System.out.println(heap.poll());
////        for (Integer i : heap){
////            System.out.println(i);
////        }
////        System.out.println( );
////        PriorityQueue<Integer> heap2 = new PriorityQueue<>((o1, o2) ->{return  o2-o1;} );
////        heap2.add(1);
////        heap2.add(2);
////        heap2.add(3);
////        heap2.add(5);
////        heap2.add(4);
////        heap2.add(6);
////       //如何实现更换位置呢？ 应该可以不用heap中自己实现， 需要用一个hashMap 做反向表
////        System.out.println(heap2.poll());
////        for (Integer i : heap2){
////            System.out.println(i);     //按照的是数组的存储顺序
//        }
//    }
//}
