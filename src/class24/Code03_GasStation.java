package class24;

import java.util.LinkedList;
//  技巧一  环形路线，使用2N拓展 ， 避免使用  i%N
//  技巧二  使用累加和，代替窗口内每个位置的累加和计算,使寻找每个以i开始的路径的搜索变成累加和的计算
//  技巧三   使用最小值代替每个位置<0的搜索， 从而带出窗口最小值问题
// 测试链接：https://leetcode.com/problems/gas-station
public class Code03_GasStation {

	// 这个方法的时间复杂度O(N)，额外空间复杂度O(N)
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		boolean[] good = goodArray(gas, cost);
		for (int i = 0; i < gas.length; i++) {
			if (good[i]) {
				return i;
			}
		}
		return -1;
	}

	public static boolean[] goodArray(int[] g, int[] c) {
		int N = g.length;
		int M = N << 1;
		int[] arr = new int[M]; //辅助数组2倍长度  gas - cost
		for (int i = 0; i < N; i++) {
			arr[i] = g[i] - c[i];
			arr[i + N] = g[i] - c[i];
		}
		//累加和
		for (int i = 1; i < M; i++) {
			arr[i] += arr[i - 1];
		}
		LinkedList<Integer> w = new LinkedList<>();
		//滑动记录最小值 0-N-1
		for (int i = 0; i < N; i++) {
			while (!w.isEmpty() && arr[w.peekLast()] >= arr[i]) {
				w.pollLast();
			}
			w.addLast(i);
		}
		boolean[] ans = new boolean[N];
		//i开始位置，j结束位置    offset为每次还原累加和的被减数
		for (int offset = 0, i = 0, j = N; j < M; offset = arr[i++], j++) {
			//环线上所有以i开头的位置的站，都能到达，说明i是好的位置
			if (arr[w.peekFirst()] - offset >= 0) {
				ans[i] = true;
			}
			//默认都是不能到的
			//更新 淘汰窗口
			if (w.peekFirst() == i) {
				w.pollFirst();
			}
			//增加 下一个j结束值
			while (!w.isEmpty() && arr[w.peekLast()] >= arr[j]) {
				w.pollLast();
			}
			w.addLast(j);
		}
		return ans;
	}

}
