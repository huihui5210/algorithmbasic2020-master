package class18;

public class Practice01_win {
    public static int win(int[] arr){
        if (arr == null || arr.length == 0){
            return -1;
        }
        //注意这样设计， f,s互相解耦 ， 先手、后手的win法在程序设计初期就解耦
        int first = f(arr, 0 , arr.length -1);
        int second = s(arr, 0 , arr.length -1);
        return Math.max(first,second);
    }

    private static int s(int[] arr, int L, int R) {
        //说明只有1张牌时，先手拿了，没有牌了
        if (L == R){
            return 0;
        }
        int ans1 = f(arr,L,R-1);
        int ans2 = f(arr,L+1,R);
        return Math.min(ans1,ans2);
    }

    private static int f(int[] arr, int L, int R) {
    if (L ==R){
        return arr[L];
    }
    int ans1 = arr[L] + s(arr,L+1,R);
    int ans2 = arr[R] + s(arr,L,R-1);
    return Math.max(ans1,ans2);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{70,100,1,4};
        System.out.println(win(arr));
    }

}
