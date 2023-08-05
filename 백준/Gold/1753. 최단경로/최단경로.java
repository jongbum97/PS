import java.io.*;
import java.util.*;

public class Main {

	static int V, E, K, dp[];
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
		
		//풀이 시작
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
		
		// 우선순위큐. 최소비용인 원소들을 우선 탐색.
		PriorityQueue<Node> q = new PriorityQueue<Node>((o1, o2) -> Integer.compare(o1.cost, o2.cost));
		q.add(new Node(x, 0));
		
		//가장 먼저 탐색하는 것은 비용이 0인 자신
		dp[x] = 0;
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			int y= n.idx;
			
			// 꺼낸 노드의 비용이 기록된 비용보다 크면 스킵
			if (dp[y] < n.cost) {
				continue;
			}
			
			// 꺼낸 노드의 주변 노드 탐색
			for (int i = 0; i < list[y].size(); i++) {
				Node nn = list[y].get(i);
				
				// 연결된 모든 노드를 탐색하면 안됨. 최솟값 갱신이 가능한 경우에만 큐에 넣어줌.
				if (dp[nn.idx] > n.cost+nn.cost) {
					dp[nn.idx] = n.cost+nn.cost;	//최솟값 갱신
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

