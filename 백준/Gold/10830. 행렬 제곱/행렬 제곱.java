import java.io.*;
import java.util.*;

public class Main {

	static int N, nums[][];
	static long B;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Long.parseLong(st.nextToken());
		nums = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				nums[i][j] = Integer.parseInt(st.nextToken())%1000;
			}
		}
		
		int[][] ans = mul(B);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bw.write(ans[i][j]+" ");
			}bw.write("\n");
		}
		bw.close();
	}

	
	
	static int[][] mul(long b) {
		
		if (b==1) {
			return nums;
		}
		if (b % 2 == 0) {
			int[][] t = mul(b/2);
			return matrixMultiple(t, t);
		} else {
			int[][] r = mul((b-1)/2);
			return matrixMultiple(matrixMultiple(r, r), nums);
		}
		
		
		
	}

	static int[][] matrixMultiple(int[][] a, int[][] b) {
		int[][] c = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					c[i][j] += a[i][k]*b[k][j];
				}
				c[i][j] %= 1000;
			}
		}
		return c;
	}
}