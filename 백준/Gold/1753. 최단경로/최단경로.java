import java.io.*;
import java.util.*;

public class Main {

	static int V, E, K, dp[];
	static boolean[] visit;
	static List<Node> list[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Node(v, w));
		}
		visit = new boolean[V+1];
		dp = new int[V+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dijkstra(K);
		for (int i = 1; i <= V; i++) {
			if(dp[i]==Integer.MAX_VALUE) {
				bw.write("INF\n"); continue;
			}
			bw.write(dp[i]+"\n");
		}
		bw.close();
	}
	
	
	
	static void dijkstra(int x) {
		
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		q.add(new Node(x, 0));
		dp[x] = 0;
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			int y= n.idx;
			
			if (dp[y]<n.cost) {
				continue;
			}
			
			for (int i = 0; i < list[y].size(); i++) {
				Node nn = list[y].get(i);
				
				if (dp[nn.idx] > n.cost+nn.cost) {
					dp[nn.idx] = n.cost+nn.cost;
					q.add(new Node(nn.idx, dp[nn.idx]));
				}
				
			}
			
		}
		
		
		
	}


}







class Node{
	int idx;
	int cost;
	Node(int idx, int cost){
		this.idx = idx;
		this.cost = cost;
	}
}

