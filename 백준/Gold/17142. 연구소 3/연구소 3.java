import java.io.*;
import java.util.*;

public class Main {

	static int N, M, map[][], ans;
	static boolean visit[][];
	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = -Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) M++;
			}
		}

		delete(0, 0);

		if(ans == Integer.MAX_VALUE) {
			ans = -1;
		}
		System.out.println(ans);

	}

	static void delete(int cnt, int p){

		if(cnt == M) {
			int t = start();
			for(int i=0; i<N; i++){
				for(int j=0; j<N; j++){
					if(!visit[i][j] && map[i][j] == 0) return;
				}
			}
			ans = Math.min(ans, t);
			return;
		}

		int a = p/N;
		int b = p%N;

		for(int i=a; i<N; i++){
			for(int j=0; j<N; j++){
				if(i==a && j<b) continue;
				if(map[i][j] == 2){
					map[i][j] = -1;
					delete(cnt+1, i*N+j+1);
					map[i][j] = 2;
				}
			}
		}

	}

	static int start(){
		int t = 0;
		visit = new boolean[N][N];
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(map[i][j] == 2){
					q.add(new Node(i, j, 0));
					visit[i][j] = true;
				}
			}
		}

		while(!q.isEmpty()){

			Node n = q.remove();
			if(n.cost >= ans) return Integer.MAX_VALUE;
			if(map[n.x][n.y] != -1){
				t = n.cost;
			}

			for(int i=0; i<4; i++){
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0 || a>N-1 || b<0 || b>N-1) continue;
				if(visit[a][b] || map[a][b] > 0) continue;
				q.add(new Node(a, b, n.cost + 1));
				visit[a][b] = true;
			}

		}

		return t;

	}

	static class Node{
		int x;
		int y;
		int cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}
	}

}
