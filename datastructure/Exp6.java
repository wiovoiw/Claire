import java.util.*;
public class Exp6{
	public static void disp(int[][] A){
		int n = A.length;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++)
				System.out.printf("%4d", A[i][j]);
			System.out.println();
		}
	}
	public static void compression(int[][] A, int[] a){
		for(int i = 0; i < A.length; i++)
			for(int j = 0; j <= i; j++){
				int k = i * (i + 1)/2 + j;
				a[k] = A[i][j];
			}
	}
	public static int[] getij(int k){
		int[] ans = new int[2];
		int i = (int)(-1 + Math.sqrt(1 + 8 * k))/2;
		int j = k - i * (i + 1)/2;
		ans[0] = i; ans[1] = j;
		return ans;
	}
	public static void Restore(int b[], int[][] C){
		int[] ans = new int[2];
		int m = b.length;
		int n = (int)(-1 + Math.sqrt(1 + 8 * m))/2;
		for(int k = 0; k < m; k++){
			ans = getij(k);
			int i = ans[0];
			int j = ans[1];
			C[i][j] = b[k];
		}
		for(int i = 0; i < n; i++)
			for(int j = i + 1; j < n; j++)
				C[i][j] = C[j][i];
	}
	public static void main(String[] args){
		System.out.printf("\n * * * * * * * * * 测试1 * * * * * * * * * \n");
		int n = 3;
		int[][] A = {{1, 2, 3}, {2, 4, 5}, {3, 5, 6}};
		int[][] C = new int[n][n];
		int[] a = new int[n * (n + 1)/2];
		System.out.println(" A:"); disp(A);
		System.out.println(" A压缩得到a");
		compression(A, a);
		System.out.print(" a:");
		for(int i = 0; i < a.length; i++)
			System.out.print(" " + a[i]);
		System.out.println();
		System.out.println(" 由a恢复得到C");
		Restore(a, C);
		System.out.println(" C:"); disp(C);
	}
}