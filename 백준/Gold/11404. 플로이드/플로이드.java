import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, cost[][];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new int[N+1][N+1];
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				if(i==j) cost[i][j] = 0;
				else cost[i][j] = 1000000000;
			}
		}
		StringTokenizer st;
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			cost[a][b] = Math.min(cost[a][b], c);
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(cost[i]));
//		}System.out.println();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
				}
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(Arrays.toString(cost[i]));
//		}System.out.println();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(cost[i][j]==1000000000) sb.append(0).append(" ");
				else sb.append(cost[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
	
	
}