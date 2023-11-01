public class Exp5{                   //解法1
	static int[] dp = new int[100];
	public static int solve1(int n){
		if(n == 1) return 1;
		if(n == 2) return 2;
		return solve1(n - 1) + solve1(n - 2);
	}


	// 解法2
	public static int solve2(int n){
		if(dp[n] != 0)
			return dp[n];
		if(n == 1){
			dp[1] = 1;
			return dp[1];
		}
		if(n == 2){
			dp[2] = 2;
			return dp[2];
		}
		dp[n] = solve2(n - 1) + solve2(n - 2);
		return dp[n];	
	}

	// 解法3
	public static int solve3(int n){
		dp[1] = 1;
		dp[2] = 2;
		for(int i = 3; i <= n; i++)
			dp[i] = dp[i - 1] + dp[i - 2];
		return dp[n];
	}

	// 解法4
	public static int solve4(int n){
		int a = 1;
		int b = 2;
		int c = 0;
		if(n == 1) return 1;
		if(n == 2) return 2;
		for(int i = 3; i <= n; i++){
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}	
		public static void main(String[] args){
			int n = 10;
			System.out.printf("\n n = %d\n", n);
			System.out.printf("解法1: %d\n", solve1(n));
			System.out.printf("解法2: %d\n", solve2(n));
			System.out.printf("解法3: %d\n", solve3(n));
			System.out.printf("解法4: %d\n", solve4(n));
		}
	}