package class19;

public class PracticeKnapsack {
    public static int maxValue(int[] w, int[] v  , int bag){
        if (bag <=0  || w == null || w.length ==0 || v ==null || v.length==0){
            return 0;
        }
        return process(w,v,bag,0);
    }
    public static int process(int[] w, int[] v ,int rest , int index){
        if (index == w.length){
            return 0;
        }
        int ans1 = process(w,v,rest,index+1);
        int ans2 = -1;
        if (rest - w[index] <0){
            ans2 = process(w,v,rest,index+1);
        }else{
            ans2 = process(w,v,rest+1,index+1) + v[index];
        }
        return Math.max(ans1,ans2);
    }



}
