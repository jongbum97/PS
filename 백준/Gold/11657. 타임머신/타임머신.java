import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static long dist[], INF = 100000000000000L;
	static List<int[]> list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		
		dist = new long[N+1];
		Arrays.fill(dist, INF);
		dist[1] = 0;
//		System.out.println(Arrays.toString(dist));
		for (int t = 0; t < N-1; t++) {
			for (int i = 0; i < M; i++) {
				int[] tmp = list.get(i);
				if(dist[tmp[0]] != INF && dist[tmp[1]] > dist[tmp[0]] + tmp[2]) {
					dist[tmp[1]] = dist[tmp[0]] + tmp[2];
				}
			}
//			System.out.println(Arrays.toString(dist));
		}
		long[] tmpp = dist.clone();
		for (int i = 0; i < M; i++) {
			int[] tmp = list.get(i);
			if(dist[tmp[0]] != INF && dist[tmp[1]] > dist[tmp[0]] + tmp[2]) {
				dist[tmp[1]] = dist[tmp[0]] + tmp[2];
			}
		}
		boolean ans = false;
		for (int i = 1; i <= N; i++) {
			if(dist[i] != tmpp[i]) {
				ans = true;
				break;
			}
		}
		
		if(ans) System.out.println(-1);
		else {
			for (int i = 2; i <= N; i++) {
				if(dist[i]==INF) sb.append(-1).append("\n");
				else sb.append(dist[i]).append("\n");
			}
			System.out.print(sb.toString());
		}

	}
	
	
}