import java.io.*;
import java.util.*;

public class Main {

	static int V, dis[], cnt, max;
	static List<Node>[] line;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0){
			st  = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			line = new List[V+1];
			for (int i=1; i<=V; i++){
				line[i] = new ArrayList<>();
			}
			while (d-- > 0){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());
				line[b].add(new Node(a, cost));
			}

			cnt = 0;
			max = 0;
			dijkstra(c);

			sb.append(cnt).append(" ").append(max).append("\n");

		}

		System.out.println(sb);

	}

	static void dijkstra(int start){
		dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		dis[start] = 0;
		Queue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
		q.add(new Node(start, 0));

		while (!q.isEmpty()){
			Node n = q.remove();

			if(dis[n.y] < n.cost) continue;
			cnt++;
			max = Math.max(max, dis[n.y]);

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
