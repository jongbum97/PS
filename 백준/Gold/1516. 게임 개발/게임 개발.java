import java.io.*;
import java.util.*;

public class Main {

	static int N, cost[], edgeCount[], dp[], ans;
	static List<Integer>[] line;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		cost = new int[N+1];
		line = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			line[i] = new ArrayList<>();
		}
		edgeCount = new int[N+1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			cost[i] = Integer.parseInt(st.nextToken());
			
			int k = Integer.parseInt(st.nextToken());
			while (k != -1) {
				line[k].add(i);
				edgeCount[i]++;
				k = Integer.parseInt(st.nextToken());
			}
		}
		
//		System.out.println(Arrays.toString(cost));
//		System.out.println(Arrays.toString(edgeCount));
//		for (int i = 1; i <= N; i++) {
//			System.out.println(line[i]);
//		}
	
		
		dp = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(edgeCount[i]==0) {
				q.add(i);
				dp[i] = cost[i];
			}
		}
		
		while (!q.isEmpty()) {
			
			int x = q.remove();
			
			for (int e : line[x]) {
				edgeCount[e]--;
				if (edgeCount[e]==0) {
					q.add(e);
				}
				dp[e] = Math.max(dp[e], dp[x] + cost[e]);
			}
			
		}
		
		for (int i = 1; i <= N; i++) {
			bw.write(dp[i]+"\n");
		}
		
		bw.close();
		
		
	}
	
}
