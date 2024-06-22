import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][], ans[][];
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int cnt = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;

			map = new int[N][N];
			for (int i=0; i<N; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++){
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			ans = new int[N][N];
			for(int i=0; i<N; i++){
				Arrays.fill(ans[i], Integer.MAX_VALUE);
			}
			dijkstra();

			sb.append("Problem ").append(++cnt).append(": ").append(ans[N-1][N-1]).append("\n");
		}

		System.out.println(sb);
	}

	private static void dijkstra() {

		Queue<Node> q = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));
		q.add(new Node(0, 0, map[0][0]));
		ans[0][0] = map[0][0];

		while (!q.isEmpty()){

			Node n = q.remove();

//			if(n.x == N-1 && n.y == N-1) return;
//			if(ans[n.x][n.y] < n.cost) continue;

			for(int i=0; i<4; i++){
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0 || a>N-1 || b<0 || b>N-1) continue;
				if(ans[a][b] <= n.cost + map[a][b]) continue;

				ans[a][b] = n.cost + map[a][b];
				q.add(new Node(a, b, ans[a][b]));

			}


		}

	}


}
class Node{
	int x;
	int y;
	int cost;
	Node(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
