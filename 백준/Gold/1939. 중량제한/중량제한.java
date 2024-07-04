import java.io.*;
import java.util.*;

public class Main {

	static int N, M, start, end, dis[];
	static Map<Integer, Integer> line[];
	static boolean visit[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new HashMap[N+1];
		for(int i=1; i<=N; i++){
			line[i] = new HashMap<>();
		}
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			line[a].put(b, Math.max(line[a].getOrDefault(b, 0), c));
			line[b].put(a, Math.max(line[b].getOrDefault(a, 0), c));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());


		dis = new int[N+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		visit = new boolean[N+1];
		Queue<Node> q = new PriorityQueue<>();
		q.add(new Node(0, start, Integer.MAX_VALUE));

		while(!q.isEmpty()){
			Node n = q.remove();

			if(visit[n.y]) continue;
			visit[n.y] = true;
			dis[n.y] = Math.min(dis[n.x], n.cost);

			if(n.y == end) break;

			line[n.y].forEach((y, cost) -> {
				if(!visit[y]){
					q.add(new Node(n.y, y, cost));
				}
			});

		}

		System.out.println(dis[end]);

	}

	static class Node implements Comparable{
		int x;
		int y;
		int cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Object o){
			return ((Node)o).cost - this.cost;
		}
	}

}
