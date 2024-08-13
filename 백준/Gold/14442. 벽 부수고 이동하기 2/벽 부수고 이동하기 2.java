import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, map[][], dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1}, dist[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i=0; i<N; i++){
			String input = br.readLine();
			for(int j=0; j<M; j++){
				map[i][j] = input.charAt(j) - '0';
			}
		}
		dist = new int[N][M][K+1];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				Arrays.fill(dist[i][j], Integer.MAX_VALUE);
			}
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 0, dist[0][0][0] = 0));

		while(!q.isEmpty()){

			Node n = q.remove();

			if(dist[n.x][n.y][n.cnt] < n.dist) continue;

			for(int i=0; i<4; i++){
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0 || a>N-1 || b<0 || b>M-1) continue;
				if(map[a][b] == 0){
					if(dist[a][b][n.cnt] > n.dist+1)
						q.add(new Node(a, b, n.cnt, dist[a][b][n.cnt] = n.dist+1));

				}else{
					if(n.cnt < K && dist[a][b][n.cnt+1] > n.dist+1)
						q.add(new Node(a, b, n.cnt+1, dist[a][b][n.cnt+1] = n.dist+1));
				}
			}

		}

		int ans = Integer.MAX_VALUE;
		for(int i=0; i<=K; i++){
			ans = Math.min(ans, dist[N-1][M-1][i]);
		}
		if(ans == Integer.MAX_VALUE)
			ans = -2;

		System.out.println(ans+1);

	}

	static class Node{
		int x;
		int y;
		int dist;
		int cnt;
		Node(int x, int y, int cnt, int dist){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.dist = dist;
		}
	}

}