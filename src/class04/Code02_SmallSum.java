package class04;

public class Code02_SmallSum {

	public static int mergeSortMy(int[] arr) {
		if (arr == null || arr.length == 0){
			return 0;
		}
		return processMy(arr,0,arr.length-1);
	}

	private static int processMy(int[] arr, int L, int R) {
		if (L==R){
			return 0;
		}
		int mid = L + ((R-L)>>1);

		return	processMy(arr , L , mid)+
		processMy(arr , mid+1,R)+
		mergeMy(arr,L,mid,R);
	}

	private static int mergeMy(int[] arr, int L, int mid, int R) {
		int[] help = new int[R-L+1];
		int index = 0;
		int indexL =L;
		int indexR =mid+1;
		int res = 0;
		while (indexL<=mid && indexR<=R){
			if (arr[indexL] < arr[indexR]){
				res += (R -indexR+1)* arr[indexL];}
			if (arr[indexL] < arr[indexR]){     // 相等情况 右边先取 这样右边剩下的就是大于左边的数
				help[index++] = arr[indexL++];
			}else{
				help[index++] = arr[indexR++];
			}
		}
		while (indexL<=mid){
			help[index++] = arr[indexL++];
		}
		while (indexR<=R){
			help[index++] = arr[indexR++];
		}
		for (int i = 0; i<help.length ;i++){
			arr[L+i] = help[i];
		}
		return res;
	}




	public static int smallSum(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		return process(arr, 0, arr.length - 1);
	}

	// arr[L..R]既要排好序，也要求小和返回
	// 所有merge时，产生的小和，累加
	// 左 排序   merge
	// 右 排序  merge
	// merge
	public static int process(int[] arr, int L, int R) {
		if (L == R) {
			return 0;
		}
		// L < r
		int mid = L + ((R - L) >> 1);
		return 
				process(arr, L, mid)
				+ 
				process(arr, mid + 1, R)
				+ 
				merge(arr, L, mid, R);
	}

	public static int merge(int[] arr, int L, int m, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = m + 1;
		int res = 0;
		while (p1 <= m && p2 <= R) {
			res += arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0;
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}//右边完了说明左边全是大数，不产生小和了
		while (p1 <= m) {
			help[i++] = arr[p1++];
		}
		//左边完了，右边全是大数  不产生小和了
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}
		return res;
	}

	// for test
	public static int comparator(int[] arr) {
		if (arr == null || arr.length < 2) {
			return 0;
		}
		int res = 0;
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				res += arr[j] < arr[i] ? arr[j] : 0;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 5;
		int maxValue = 10;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
//			int[] arr1 = {1  , -5 , 4,1};
//			int[] arr2 = {1  , -5 , 4,1};
			printArray(arr1);
			printArray(arr2);
			int ans1 =smallSum(arr1);
			int ans2 =mergeSortMy(arr2);
			if ( ans1!= ans2) {
				System.out.println(ans1);
				System.out.println(ans2);
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
	}

}
