package class19;

public class Code01_Knapsack {
	public static int maxValue2(int[] w, int[] v  , int bag){
		if (bag <=0  || w == null || w.length ==0 || v ==null || v.length==0){
			return 0;
		}
		int[][] dp = new int[bag+1][w.length+1];
		return process2(w,v,bag,0,dp);
	}
	public static int process2(int[] w, int[] v ,int rest , int index, int[][] dp){
		if (dp[rest][index]!=0){
			return dp[rest][index];
		}
		if (index == w.length){
			return 0;
		}
		int ans1 = process2(w,v,rest,index+1,dp);
		int ans2 = -1;
		if (rest - w[index] <0){
			//这个不选的语句可以注释，应为改分支就是要强行选择这种结果，选了就直接剪枝！
//			ans2 = process2(w,v,rest,index+1);
		}else{
			ans2 = process2(w,v,rest - w[index],index+1,dp) + v[index];
		}
		dp[rest][index] = Math.max(ans1,ans2);
		return dp[rest][index];
	}
	// 所有的货，重量和价值，都在w和v数组里
	// 为了方便，其中没有负数
	// bag背包容量，不能超过这个载重
	// 返回：不超重的情况下，能够得到的最大价值
	public static int maxValue(int[] w, int[] v, int bag) {
		if (w == null || v == null || w.length != v.length || w.length == 0) {
			return 0;
		}
		// 尝试函数！
		return process(w, v, 0, bag);
	}

	// index 0~N
	// rest 负~bag
	public static int process(int[] w, int[] v, int index, int rest) {
		if (rest < 0) {
			return -1;
		}
		if (index == w.length) {
			return 0;
		}
		int p1 = process(w, v, index + 1, rest);
		int p2 = 0;
		int next = process(w, v, index + 1, rest - w[index]);
		if (next != -1) {
			p2 = v[index] + next;
		}
		return Math.max(p1, p2);
	}

	public static int dp(int[] w, int[] v, int bag) {
		if (w == null || v == null || w.length != v.length || w.length == 0) {
			return 0;
		}
		int N = w.length;
		int[][] dp = new int[N + 1][bag + 1];
		for (int index = N - 1; index >= 0; index--) {
			for (int rest = 0; rest <= bag; rest++) {
				int p1 = dp[index + 1][rest];
				int p2 = 0;
				int next = rest - w[index] < 0 ? -1 : dp[index + 1][rest - w[index]];
				if (next != -1) {
					p2 = v[index] + next;
				}
				dp[index][rest] = Math.max(p1, p2);
			}
		}
		return dp[0][bag];
	}

	public static void main(String[] args) {
		int[] weights = { 3, 2, 4, 7, 3, 1, 7 };
		int[] values = { 5, 6, 3, 19, 12, 4, 2 };
		int bag = 15;
		System.out.println(maxValue(weights, values, bag));
		System.out.println(maxValue2(weights, values, bag));
		System.out.println(dp(weights, values, bag));
	}

}
