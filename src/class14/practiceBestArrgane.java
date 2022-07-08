package class14;

import java.util.Arrays;

public class practiceBestArrgane {
    public static class Program {
        public int start;
        public int end;

        public Program(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static int process(Program[] programs, int done, int timeLine) {
        Arrays.sort(programs ,
                (Program o1,Program o2)->{return  o1.end - o2.end;}
        );
        int ans = 0;
        int start = done;
        for (Program o1 :programs){
            if (start <= o1.start && timeLine >= o1.end){
                ans++;
                start = o1.end;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Program[] programs = generatePrograms(3,12);
        System.out.println(process(programs, 0, 12));
    }
    public static Program[] generatePrograms(int programSize, int timeMax) {
        Program[] ans = new Program[(int) (Math.random() * (programSize + 1))];
        for (int i = 0; i < ans.length; i++) {
            int r1 = (int) (Math.random() * (timeMax + 1));
            int r2 = (int) (Math.random() * (timeMax + 1));
            if (r1 == r2) {
                ans[i] = new Program(r1, r1 + 1);
            } else {
                ans[i] = new Program(Math.min(r1, r2), Math.max(r1, r2));
            }
        }
        return ans;
    }
}
