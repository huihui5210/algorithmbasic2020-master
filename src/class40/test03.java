package class40;

public class test03 {
    public static int maxLengthAwesome(int[] arr, int k) {
        int len =arr.length;
        int[] minSum = new int[len];
        int[] minSumEnd = new int[len];
        int sumEnd =arr[len-1];
        minSumEnd[len - 1 ] = len - 1;
        minSum[len -1 ] = arr[len-1];
        for (int i =len-2 ; i>=0 ; i--){
            sumEnd +=arr[i];
            minSum[i] = Math.min(sumEnd , arr[i]);
            //没有变的话右边界和之前相同，变了话下标就变成自己
            minSumEnd[i] = minSum[i] == sumEnd ? minSumEnd[i+1] : i ;
            sumEnd = minSum[i];
        }
        //加工出来了一个整体！ 这个整体是能找到每个开始和对应的结束位置，求出最小和的数据！
        int sum = 0;
        int end = 0; //end是这个坨的结尾
        int ans = 0;
        //i是遍历整个开头！
        for (int  i = 0; i< arr.length ; i++){
            //吸进来 但是O（1）的戏
            while(end < arr.length  && sum + minSum[end] <= k ){
                sum = sum + minSum[end];
                end = minSumEnd[end] + 1;
            }
            ans = Math.max(ans , end - i);
            if (end<i){
                sum -= arr[i];
            }else{
                end = i + 1;
            }
        }
     return  ans;
    }

    public static void main(String[] args) {
        int[] ints = new int[]{1,2,-4,3,7,-2,4,-3};
        maxLengthAwesome(ints,0);
    }
}
