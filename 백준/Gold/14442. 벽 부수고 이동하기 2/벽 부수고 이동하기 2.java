import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, map[][], dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1}, ans;
	static boolean visit[][][];

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
		visit = new boolean[N][M][K+1];
		ans = Integer.MAX_VALUE;

		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0, 0, 1));
		visit[0][0][0] = true;

		while(!q.isEmpty()){

			Node n = q.remove();
			if(n.x==N-1 && n.y==M-1) {
				ans = Math.min(ans, n.dist);
				continue;
			}

			for(int i=0; i<4; i++){
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0 || a>N-1 || b<0 || b>M-1 ) continue;
				if(map[a][b] == 0){
					if(!visit[a][b][n.k]){
						q.add(new Node(a, b, n.k, n.dist+1));
						visit[a][b][n.k] = true;
					}
				}else{
					if(n.k < K && !visit[a][b][n.k+1]){
						q.add(new Node(a, b, n.k+1, n.dist+1));
						visit[a][b][n.k+1] = true;
					}
				}
			}

		}

		if(ans == Integer.MAX_VALUE)
			ans = -1;

		System.out.println(ans);

	}

	static class Node{
		int x;
		int y;
		int dist;
		int k;
		Node(int x, int y, int k, int dist){
			this.x = x;
			this.y = y;
			this.k = k;
			this.dist = dist;
		}
	}

}