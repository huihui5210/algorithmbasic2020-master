package class40;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class Code01_LongestSumSubArrayLengthInPositiveArray {
	public static int getMaxLengthMy(int[] arr, int K) {
		int L = 0;
		int R = 0;
		int ans = 0;
		int sum = arr[0]; //左闭右闭
		while (R<arr.length) {
				if (sum < K) {
					R++;
					if (R>=arr.length){
						break;
					}
					sum +=arr[R]; //一来就要加 不是一来就要加 只有向右扩才加
				} else if (sum == K) {
					//注意  R当前位置没有检验
					ans = Math.max(ans, R - L+1);
					//将该位置加入 不要像多了，直接向右看能扩到哪儿  然后L++
					     //之后看能不能向右扩
					while(R+1<arr.length &&arr[R+1] == 0){
						R++;
						ans = Math.max(ans, R - L+1);
					}
					sum -= arr[L];
					L++;
					//注意有可能有0的出现  导致可以直接右扩
				} else {
					sum -= arr[L];
					L++;
				}
			}
		return ans;
	}
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
	public static int getMaxLength(int[] arr, int K) {
		if (arr == null || arr.length == 0 || K <= 0) {
			return 0;
		}
		int left = 0;
		int right = 0;
		int sum = arr[0]; //左闭右闭
		int len = 0;
		while (right < arr.length) {
			if (sum == K) { // 是答案就记录缩小窗口
				len = Math.max(len, right - left + 1);
				sum -= arr[left++];
			} else if (sum < K) { //小于就扩大
				right++;
				if (right == arr.length) {
					break;
				}
				sum += arr[right];
			} else { //大于就缩小
				sum -= arr[left++];
			}
		}
		return len;
	}

	// for test
	public static int right(int[] arr, int K) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (valid(arr, i, j, K)) {
					max = Math.max(max, j - i + 1);
				}
			}
		}
		return max;
	}

	// for test
	public static boolean valid(int[] arr, int L, int R, int K) {
		int sum = 0;
		for (int i = L; i <= R; i++) {
			sum += arr[i];
		}
		return sum == K;
	}

	// for test
	public static int[] generatePositiveArray(int size, int value) {
		int[] ans = new int[size];
		for (int i = 0; i != size; i++) {
			ans[i] = (int) (Math.random() * value) ;
		}
		return ans;
	}

	// for test
	public static void printArray(int[] arr) {
		for (int i = 0; i != arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		int len = 50;
		int value = 100;
		int testTime = 500000;
		System.out.println("test begin");
		for (int i = 0; i < testTime; i++) {
			int[] arr = generatePositiveArray(len, value);
			int K = (int) (Math.random() * value) + 1;
			int ans1 = getMaxLength(arr, K);
			int ans2 = getMaxLength2(arr, K);

			if (ans1 != ans2) {
				System.out.println("Oops!");
				printArray(arr);
				System.out.println("K : " + K);
				System.out.println(ans1);
				System.out.println(ans2);
				break;
			}
		}
		System.out.println("test end");
	}
//	int[] ints = new int[]{1,2,2,0,0,6,2,3,6};
//	int K = 5;
//		System.out.println(getMaxLengthMy(ints, K));
//		System.out.println(getMaxLength(ints, K));
//	}
}

