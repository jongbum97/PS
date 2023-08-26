import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		int N, M, T, S, G, H, dp[];
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			T = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			S = Integer.parseInt(st.nextToken());
			G = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			List<int[]>[] list = new ArrayList[N+1];
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				if((a==G&&b==H)||(b==G&&a==H)) {
					list[a].add(new int[] {b, 2*c-1});
					list[b].add(new int[] {a, 2*c-1});
				}else {
					list[a].add(new int[] {b, 2*c});
					list[b].add(new int[] {a, 2*c});
				}
			}
			
			dp = new int[N+1];
			Arrays.fill(dp, 1000000000);
			
			PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
			q.add(new Node(S, dp[S]=0));
			
			while (!q.isEmpty()) {
				
				Node n = q.remove();
				
				if(dp[n.x]<n.cost) continue;
				
				for (int[] nn : list[n.x]) {
					int a = nn[0];
					int c = nn[1];
					if(dp[a]>dp[n.x]+c) {
						q.add(new Node(a, dp[a]=dp[n.x]+c));
					}
				}
				
			}
			PriorityQueue<Integer> q2 = new PriorityQueue<>();
			for (int i = 0; i < T; i++) {
				int a = Integer.parseInt(br.readLine());
				if (dp[a]%2!=0) {
					q2.add(a);
				}
			}
			while (!q2.isEmpty()) {
				sb.append(q2.remove()).append(" ");
			}
			sb.append("\n");
		}
		bw.write(sb.toString());
		bw.close();
	}
	
	
}
class Node{
	int x;
	int cost;
	Node(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}