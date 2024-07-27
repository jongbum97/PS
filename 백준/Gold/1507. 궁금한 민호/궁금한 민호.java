import java.io.*;
import java.util.*;

public class Main {

	static int N, ans;
	static List<int[]>[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Queue<Node> q = new PriorityQueue<>();
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				int cost = Integer.parseInt(st.nextToken());
				if(j > i){
					q.add(new Node(i, j, cost));
				}
			}
		}

		line = new List[N];
		for(int i=0; i<N; i++){
			line[i] = new ArrayList<>();
		}

		while(!q.isEmpty()){

			Node n = q.remove();

			int dist = dijkstra(n.x, n.y);

			if(dist > n.cost){
				line[n.x].add(new int[]{n.y, n.cost});
				line[n.y].add(new int[]{n.x, n.cost});
				ans += n.cost;
			}else if(dist < n.cost){
				ans = -1;
				break;
			}

		}

		System.out.println(ans);

	}

	static int dijkstra(int x, int y){
		int[] dist = new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		q.add(new int[]{x, dist[x] = 0});

		while(!q.isEmpty()){

			int[] n = q.remove();
			if(dist[n[0]] < n[1]) continue;
			if(n[0] == y) break;

			for(int[] nn : line[n[0]]){
				if(dist[nn[0]] > n[1] + nn[1]){
					q.add(new int[]{nn[0], dist[nn[0]] = n[1] + nn[1]});
				}
			}

		}

		return dist[y];
	}

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
		@Override
		public int compareTo(Node n){
			return this.cost-n.cost;
		}
	}

}
