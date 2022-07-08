package class07;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Practice01 {
    public static class Line {
        public int start;
        public int end;

        public Line(int s, int e) {
            start = s;
            end = e;
        }
    }
    public static int maxCover(int[][] m) {
        Line[] lines = new Line[m.length];
        for (int i = 0; i < m.length; i++) {
            lines[i] = new Line(m[i][0], m[i][1]);
        }
        Arrays.sort(lines , ((o1,o2)->{ return  o1.start !=o2.start ? o1.start-o2.start : o2.end - o1.end ;}));
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int ans = Integer.MIN_VALUE;
        for (int  i = 0 ; i< lines.length ;i++){
            int curStart = lines[i].start;
            //弹出结束位置小于等于当前的开始位置
            while ( !heap.isEmpty() && curStart >=heap.peek()){
                heap.poll();
            }
            heap.add(lines[i].end);
            ans = ans>heap.size() ? ans :heap.size();
        }
        return ans;
    }
}
