import java.util.*;
import java.io.*;

public class Main {

	static int C, N;
	static int[][] ans;
	static int[] cost, guest;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		cost = new int[101];
		guest = new int[101];
		ans = new int[101][1001];
		for (int i = 0; i <= N; i++) {
			for (int j = 1; j <= C; j++) {
				ans[i][j] = 10000000;
			}
		}
		for (int i = 1; i <= N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			cost[i] = a;
			guest[i] = b;
			
			for (int j = 1; j <= b; j++) {
				ans[i][j] = a;
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= C; j++) {
				if (j-guest[i]<=0) {
					ans[i][j] = Math.min(ans[i-1][j], ans[i][j]);
					continue;
				}
				ans[i][j] = Math.min(ans[i-1][j], ans[i][j-guest[i]]+cost[i]);
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(ans[N][C]+"\n");
		bw.close();
		
		
		
		
		
		
		
		
		
		
		
	
		
	}
	


}