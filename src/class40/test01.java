package class40;

import com.sun.org.apache.regexp.internal.RE;

public class test01 {
    public static int getMaxLength(int[] arr, int K) {
        int L = 0;
        int R = 0;
        int ans = 0;
        int sum = arr[0];
        while (R<arr.length) {
            if (R < L) {
                R++;
            } else {
                if (sum < K) {
                    R++;
                    sum += arr[R];
                } else if (sum == K) {
                    ans = Math.max(ans, R - L + 1);
                    R++;
                    //注意有可能有0的出现  导致可以直接右扩
                } else {
                    ans -= arr[L];
                    L++;
                }
            }
        }
        return ans;
    }
//正数
    public static int getMaxLength2(int[] arr, int K) {
      int L = 0;
      int R = 0;
      int ans= 0;
      int sum = arr[0];
      while (R<arr.length){
          if (sum<K){
              R++;
              if (R < arr.length){
                  sum += arr[R];
              }
          }else if (sum == K){
              ans = Math.max(ans,R-L+1);
              sum -= arr[L++];
          }else{
              sum -= arr[L++];
          }
      }
        return ans;
    }

    public static void main(String[] args) {
     int[] ints = new int[]{1,2,3,4,5,6};
     int K= 6;
        System.out.println(getMaxLength2(ints, K));

    }
}
