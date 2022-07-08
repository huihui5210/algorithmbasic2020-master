package class23;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class PraticeSplitNum2 {
    public static int right(int[] arr) {
        if(arr == null || arr.length ==0 ){
            return  -1;
        }
        if (arr.length == 1){
            return arr[0];
        }
        if (arr.length ==2 ){
            return  Math.abs(arr[0] - arr[1]);
        }
        if (arr.length == 3){
            Arrays.sort(arr);
            int ans = Math.abs(arr[0] + arr[1] - arr[2]);
        } //单独处理
        ArrayList<Integer> list = new ArrayList<>();
        for (int num: arr){
            list.add(num);
        }
        list.sort((o1,o2)->{return o1=o2;});
        if ( (arr.length & 1 )== 1){
           int help = list.get(0) +list.get(1);
           list.remove(0) ;
           list.remove(0);
           list.add(help);
        }
        list.sort((o1,o2)->{return o1-o2;});
        int L = 0;
        int R = list.size()-1;
        int ans = 0;
        while (L+2<R){
             int qian = list.get(L) + list.get(R);
             int hou = list.get(L+1) + list.get(R-1);
             ans += qian - hou;
             L+=2;
             R-=2;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,2,4,56,1};
        System.out.println(right(arr));

    }

}
