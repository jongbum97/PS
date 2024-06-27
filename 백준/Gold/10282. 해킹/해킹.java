import java.io.*;
import java.util.*;

public class Main {

	static int V, dis[];
	static final int INF = 1_000_000_000;
	static List<Node>[] line;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc<T; tc++){
			st  = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			line = new ArrayList[V+1];
			for (int i=1; i<=V; i++){
				line[i] = new ArrayList<>();
			}
			for (int i=0; i<d; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				line[b].add(new Node(a, cost));
			}

			dijkstra(c);
			int cnt = 0;
			int max = 0;
			for (int i=1; i<=V; i++){
				if(dis[i] == Integer.MAX_VALUE) continue;
				cnt ++;
				max = Math.max(max, dis[i]);
			}

			sb.append(cnt).append(" ").append(max).append("\n");

		}

		System.out.println(sb);

	}

	static void dijkstra(int start){
		dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		Queue<Node> q = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		q.add(new Node(start, 0));

		while (!q.isEmpty()){
			Node n = q.remove();

			if(dis[n.y] < n.cost) continue;

			for(Node nn : line[n.y]){
				if(dis[nn.y] > n.cost + nn.cost){
					q.add(new Node(nn.y, dis[nn.y] = n.cost + nn.cost));
				}
			}

		}

	}

	static class Node{
		int y;
		int cost;
		Node(int y, int cost){
			this.y = y;
			this.cost = cost;
		}
	}

}
