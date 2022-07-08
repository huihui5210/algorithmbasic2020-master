package class40;

public class Code03_LongestLessSumSubArrayLength {

	public static int maxLengthAwesome(int[] arr, int k) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int[] minSums = new int[arr.length];
		int[] minSumEnds = new int[arr.length];
		minSums[arr.length - 1] = arr[arr.length - 1];
		minSumEnds[arr.length - 1] = arr.length - 1;
		for (int i = arr.length - 2; i >= 0; i--) {
			if (minSums[i + 1] < 0) {
				minSums[i] = arr[i] + minSums[i + 1];
				minSumEnds[i] = minSumEnds[i + 1];
			} else {
				minSums[i] = arr[i];
				minSumEnds[i] = i;
			}
		}
		// 迟迟扩不进来那一块儿的开头位置
		int end = 0;
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			// while循环结束之后：
			// 1) 如果以i开头的情况下，累加和<=k的最长子数组是arr[i..end-1]，看看这个子数组长度能不能更新res；
			// 2) 如果以i开头的情况下，累加和<=k的最长子数组比arr[i..end-1]短，更新还是不更新res都不会影响最终结果；
			while (end < arr.length && sum + minSums[end] <= k) {
				sum += minSums[end];
				end = minSumEnds[end] + 1; //直接加入的是一坨， 这个minSumEnds[end] + 1是一坨的右边界+1
			}
			ans = Math.max(ans, end - i); //更新长度
			//吸收不进去了！ 该缩小窗口了
			if (end > i) { // 还有窗口，哪怕窗口没有数字 [i~end) [4,4)
				sum -= arr[i];
			} else { // i == end,  即将 i++, i > end, 此时窗口概念维持不住了，所以end跟着i一起走，即放弃之前的开始位置，重新建出窗口
				end = i + 1;
			}
		}
		return ans;
	}
	public static int maxLengthAwesome2(int[] arr, int k) {
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
//		int sum = 0;
//		int end = 0; //end是这个坨的结尾
//		int ans = 0;
//		//i是遍历整个开头！
//		for (int  i = 0; i< arr.length ; i++){
//			//吸进来 但是O（1）的戏
//			while(end < arr.length  && sum + minSum[end] <= k ){
//				sum = sum + minSum[end];
//				end = minSumEnd[end] + 1;
//			}
//			ans = Math.max(ans , end - i);
//			if (end<i){
//				sum -= arr[i];
//			}else{
//				end = i + 1;
//			}
//		}
		int end = 0;
		int sum = 0;
		int ans = 0;
		for (int i = 0; i < arr.length; i++) {
			// while循环结束之后：
			// 1) 如果以i开头的情况下，累加和<=k的最长子数组是arr[i..end-1]，看看这个子数组长度能不能更新res；
			// 2) 如果以i开头的情况下，累加和<=k的最长子数组比arr[i..end-1]短，更新还是不更新res都不会影响最终结果；
			while (end < arr.length && sum + minSum[end] <= k) {
				sum += minSum[end];
				end = minSumEnd[end] + 1; //直接加入的是一坨， 这个minSumEnds[end] + 1是一坨的右边界+1
			}
			ans = Math.max(ans, end - i); //更新长度
			//吸收不进去了！ 该缩小窗口了
			if (end > i) { // 还有窗口，哪怕窗口没有数字 [i~end) [4,4)
				sum -= arr[i];
			} else { // i == end,  即将 i++, i > end, 此时窗口概念维持不住了，所以end跟着i一起走，即放弃之前的开始位置，重新建出窗口
				end = i + 1;
			}
		}
		return  ans;
	}

	public static int maxLength(int[] arr, int k) {
		int[] h = new int[arr.length + 1];
		int sum = 0;
		h[0] = sum;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			h[i + 1] = Math.max(sum, h[i]);
		}
		sum = 0;
		int res = 0;
		int pre = 0;
		int len = 0;
		for (int i = 0; i != arr.length; i++) {
			sum += arr[i];
			pre = getLessIndex(h, sum - k);
			len = pre == -1 ? 0 : i - pre + 1;
			res = Math.max(res, len);
		}
		return res;
	}

	public static int getLessIndex(int[] arr, int num) {
		int low = 0;
		int high = arr.length - 1;
		int mid = 0;
		int res = -1;
		while (low <= high) {
			mid = (low + high) / 2;
			if (arr[mid] >= num) {
				res = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return res;
	}

	// for test
	public static int[] generateRandomArray(int len, int maxValue) {
		int[] res = new int[len];
		for (int i = 0; i != res.length; i++) {
			res[i] = (int) (Math.random() * maxValue) - (maxValue / 3);
		}
		return res;
	}

	public static void main(String[] args) {
		System.out.println("test begin");
		int[] ints = new int[]{9,8,3,9,3};
		for (int i = 0; i < 10000000; i++) {
			int[] arr = generateRandomArray(5, 20);
			int k = (int) (Math.random() * 20) - 5;
			int ans = maxLengthAwesome(arr, k);
			int ans2 =maxLengthAwesome2(arr, k);
			if (ans!= ans2) {
				System.out.println("K" + k );
				System.out.println(ans);
				System.out.println(ans2);
				System.out.println("Oops!");
			}
		}
//		int k  =12;
//		System.out.println(maxLengthAwesome2(ints, k));
//		System.out.println(maxLengthAwesome(ints, k));
		System.out.println("test finish");
	}

}
