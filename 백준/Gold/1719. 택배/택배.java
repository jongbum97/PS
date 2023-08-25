import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans[][], dp[];
	static List<int[]>[] list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		ans = new int[N+1][N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b,c});
			list[b].add(new int[] {a,c});
		}
		
		for (int i = 1; i <= N; i++) {
			dijkstra(i);
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i!=j) {
					sb.append(ans[i][j]).append(" ");
				}else {
					sb.append("- ");
				}
			}sb.append("\n");
		}
		
		bw.write(sb.toString());
		bw.close();
	}

	static void dijkstra(int xx) {
		
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
		q.add(new Node(xx, dp[xx] = 0, new StringBuilder()));
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			if(dp[n.x]<n.cost) continue;
			
			for (int[] nn : list[n.x]) {
				if(dp[nn[0]]>n.cost+nn[1]) {
					q.add(new Node(nn[0], dp[nn[0]] = n.cost+nn[1], n.sb));
				}
			}
			String[] c = n.sb.toString().split(" ");
			for (int j = 1; j < c.length; j++) {
				int x = Integer.parseInt(c[0]);
				int y = Integer.parseInt(c[j]);
				ans[x][y] = Integer.parseInt(c[1]);
			}
		}
	}
}
class Node{
	int x;
	int cost;
	StringBuilder sb;
	Node(int x, int cost, StringBuilder sb){
		this.x = x;
		this.cost = cost;
		this.sb = new StringBuilder(sb.toString());
		this.sb.append(x).append(" ");
	}
}