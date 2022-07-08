package class05;

public class QuickSort {
    //就是将L，R排好序 ， quickSort就是将中间等于部分一批处理好 ， 然后递归处理小于  大于区
    public static void process(int[] arr, int L, int R) {
        if (L>=R || R-L <2){
            return;
        }
        //返回左右边界
        int[] pro = quickSort(arr,L,R);
        process(arr,L,pro[0] );
        process(arr,pro[1] ,R);
    }
    // int[] 就是返回实际小于区边界   大于区边界 （注意边界都是闭区间）
    public static int[] quickSort(int[] arr, int L , int R){
        if (L>=R){
            return  new int[]{-1,-1};
        }

        int less = L-1 ; int more = R; //more是包含了R位置的
        int index = L;

        while (index < more){
            if (arr[index] <arr[R]){
                swap(arr,less+1,index);
                index++;
                less++;
            }else if(arr[index] == arr[R]){
                index++;
            }else{
                swap(arr,index,more-1);
                more--;
            }
        }
        swap(arr,R,more);
        return new int[]{less,more+1};
    }
    public static void swap(int[] arr, int i , int j){
      int temp = arr[i];
      arr[i] = arr[j];
      arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] ints = new  int[]{3,1,7,4,6,3};
        process(ints,0,ints.length-1);
        for (int num : ints){
        System.out.println(num);
        }
    }
}
