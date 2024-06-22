import java.io.*;
import java.util.*;

public class Main {

	static int N, E, V1, V2, line[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		line = new int[N+1][N+1];
		for (int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			line[a][b] = c;
			line[b][a] = c;
		}
		st = new StringTokenizer(br.readLine());
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());

		int startToV1 = dijkstra(1, V1);
		int startToV2 = dijkstra(1, V2);
		int V1ToV2 = dijkstra(V1, V2);
		int V1ToEnd = dijkstra(V1, N);
		int V2ToEnd = dijkstra(V2, N);

		int ans = Math.min(startToV1+V1ToV2+V2ToEnd, startToV2+V1ToV2+V1ToEnd);
		if(ans >= 500_000_000) ans = -1;

		System.out.println(ans);

	}

	private static int dijkstra(int start, int end) {
		int[] dis = new int[N+1];
		Arrays.fill(dis, 500_000_000);

		Queue<Node> q = new PriorityQueue<>((a, b) -> a.cost - b.cost);
		q.add(new Node(start, 0));
		dis[start] = 0;

		while(!q.isEmpty()){

			Node n = q.remove();

			if(n.y == end) break;

			for(int i=0; i<=N; i++){
				if(line[n.y][i] == 0) continue;
				if(dis[i] <= n.cost + line[n.y][i]) continue;

				dis[i] = n.cost + line[n.y][i];
				q.add(new Node(i, dis[i]));
			}

		}

		return dis[end];

	}


}
class Node{
	int y;
	int cost;
	Node(int y, int cost){
		this.y = y;
		this.cost = cost;
	}
}