package class21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
//这种dfs的尝试方法，会有路径重复问题
public class PracticeCount {
//    public static int count(int[] ints,int arm){
//        if (ints == null || ints.length == 0 || arm <0){
//            return 0;
//        }
//        HashSet<int[]> help = new HashSet<>();
//         process(arm , ints,help);
//        return help.size();
//    }
//
//    private static int process(int rest, int[] ints, HashSet<int[]> help){
//        if (rest < 0 ){ return 0; }
//        int count = 0;
//        int[] arrayList = new int[ints.length];
//        for (int number : ints){
//            int rest1= rest - number;
//            if (rest1 < 0){
//                //还原该分支
//                arrayList = null;
//                return 0;
//            }else if (rest1 == 0){
//                arrayList.add(number);
//                ArrayList<Integer> a = new ArrayList();
//                for (int nu: arrayList){
//                    a.add(nu);
//                }
//                a.sort((o1,o2)->{return o1-o2;});
//                help.add(a);
//                return 1;
//            }else{
//                arrayList.add(number);
//                count +=process(rest1,ints,help);
//                arrayList.remove(number);
//            }
//        }
//        return count;
//    }
    public static int count(int[] ints,int arm){
        if (ints == null || ints.length == 0 || arm <0){
            return 0;
        }
        int count = process(ints,0,arm);
        return count;
    }
    public static int count2(int[] ints,int arm){
        if (ints == null || ints.length == 0 || arm <0){
            return 0;
        }
        int count = process2(ints,0,arm);
        return count;
    }

    //知道张数还有面值！
    private static int process2(int[] ints, int index, int rest) {
        if (index ==ints.length){
            return rest==0?1:1;
        }
//        for (int zhang = 0){}
    return 0;

    }
//注意这个是无限张数
    public static int process(int[] ints ,int index , int rest){
        if (index == ints.length){return rest==0 ? 1:0; }

        int count = 0;
        //尝试  每个index下的张数    使用的zhang*ints[index]<=rest 做外界限制（由于张数无线） 有钱数的张数限制是 zhang <= zhang[index ]
        for (int zhang=0 ; zhang*ints[index]<=rest ; zhang++){
            count += process(ints,index+1,rest - zhang*ints[index]);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,3,4};
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num :ints){
            if (map.containsKey(num)){
                map.put(num, map.get(num)+1);
            }else{
                map.put(num,0);
            }
        }
        System.out.println(count(ints, 3));// 注意这样的流程有重复项    比如 arm： 3 有  1，2 和2，1没有区分
        //需要一个路径去重排好序的一个数组  path用int[]  hashset 这样就复杂了，当然如果只是确定一个路径就没有关系
    }
}
