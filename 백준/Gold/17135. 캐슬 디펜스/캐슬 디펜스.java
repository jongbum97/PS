import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, D, dr[]={0,-1,0}, dc[]={-1,0,1}, ans, tmp2;
	static boolean map[][], visit[][], archer[], map2[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		int[] tmp = new int[M];
		map = new boolean[N+1][M];
		map2 = new boolean[N+1][M];
		archer = new boolean[M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tmp[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < M; j++) {
				if(tmp[j]==1) map2[i][j] = true;
			}
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map2[i][j]) count++;
			}
		}
		ans = count;
		tmp2 = Integer.MAX_VALUE;
		
		choose(0, 0);
		
		System.out.println(ans-tmp2);
		
	}
	static void game() {
		for (int i = 0; i <= N; i++) {
			map[i] = map2[i].clone();
		}
		
		int t = 0;
		while (t<N) {
			Node[] del = new Node[3];
			int cnt = 0;
			for (int i = 0; i < M; i++) {
				if(archer[i]) {
					del[cnt++] = shoot(N-t, i);
				}
			}
			for (int i = 0; i < 3; i++) {
				Node n = del[i];
				map[n.x][n.y] = false; 
			}
			t++;
		}
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]) count++;
			}
		}
		tmp2 = Math.min(tmp2, count);
	}
	
	static void choose(int n, int m) {
		if (n==3) {
			game();
			return;
		}
		
		for (int i = m; i < M; i++) {
			archer[i] = true;
			choose(n+1, i+1);
			archer[i] = false;
		}
		
		
	}
	
	static Node shoot(int x, int y) {
		visit = new boolean[N+1][M];
		if(map[x-1][y]) return new Node(x-1, y);
		visit[x-1][y] = true;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x-1, y));
		
		while (!q.isEmpty()) {
			Node n = q.remove();
			
			for (int i = 0; i < 3; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||b<0||b>M-1) continue;
				if((Math.abs(x-a)+Math.abs(y-b))>D) break;
				if(visit[a][b]) continue;
				if(map[a][b]) return new Node(a, b);
				visit[a][b] = true;
				q.add(new Node(a, b));
			}
			
		}
		return new Node(N, 0);
	}

}
class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}