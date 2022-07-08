package class40;

import java.util.HashMap;

public class test02 {
    public static int maxLength(int[] arr, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int sum = 0;
        int index = 0;
        int ans = 0;
        hashMap.put(0,-1);
        while (index < arr.length){
            sum += arr[index];
            int target = k -sum;
            if (hashMap.containsKey(target)){
                ans = Math.max(ans , index - hashMap.get(target));
            }
            if (!hashMap.containsKey(sum)){
                hashMap.put(sum,index);
            }
            index++;
        }
        return  ans;
    }
}
