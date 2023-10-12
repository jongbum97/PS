import java.io.*;
import java.util.*;

public class Main {
	
	static long cost[][], INF=Long.MAX_VALUE;
	static int N, M, from[][];
	static boolean visit[], check;
	static List<Integer> path;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		cost = new long[N+1][N+1];
		from = new int[N+1][N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(cost[i], INF);
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(cost[a][b] > c) {
				cost[a][b] = c;
				from[a][b] = a;
			}
		}
		
		// 플로이드-워샬
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					if(cost[j][i]==INF || cost[i][k]==INF) continue;
					if(cost[j][k] > cost[j][i] + cost[i][k]) {
						cost[j][k] = cost[j][i] + cost[i][k];
						from[j][k] = from[i][k];
					}
				}
			}
		}
		
		// 도착할 수 없거나 출발지와 도착지가 같으면 0
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(cost[i][j]==INF || i==j) cost[i][j] = 0;
			}
		}
		
		// 최단거리 배열 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				sb.append(cost[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		// 모든경로 출력
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if(cost[i][j]==0) {
					sb.append(0).append("\n");
					continue;
				}
				int idx = j;
				Stack<Integer> stack = new Stack<>();
				stack.push(j);
				while(i != idx) {
					
					stack.push(idx = from[i][idx]);
					
				}
				sb.append(stack.size()).append(" ");
				while (!stack.isEmpty()) {
					sb.append(stack.pop()).append(" ");
				}
				sb.append("\n");
			}
		}
		
		
		
		System.out.print(sb.toString());
		

	}

}