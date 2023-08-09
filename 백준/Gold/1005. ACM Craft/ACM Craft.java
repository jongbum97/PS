import java.io.*;
import java.util.*;

public class Main {

	static int N, K, W, cost[], edgeCount[], dp[], ans;
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			cost = new int[N+1];
			list = new ArrayList[N+1];
			edgeCount = new int[N+1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				cost[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				edgeCount[b]++;
			}
			W = Integer.parseInt(br.readLine()); 
			
			dp = new int[N+1];
			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= N; i++) {
				if (edgeCount[i]==0) {
					q.add(i);
					dp[i] = cost[i];
				}
			}
			
			while (!q.isEmpty()) {
				
				if (edgeCount[W]==0) {
					break;
				}
				
				int x = q.remove();
				
				for (int e : list[x]) {
					edgeCount[e]--;
					if(edgeCount[e]==0) q.add(e);
					dp[e] = Math.max(dp[x] + cost[e], dp[e]);
				}
				
			}
			
			bw.write(dp[W]+"\n");
		}
		
		
		
		bw.close();
		
		
	}
	
}
