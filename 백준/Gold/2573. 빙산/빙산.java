import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ice[][], dr[]= {-1,0,1,0}, dc[]= {0,1,0,-1}, tmp[][];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ice = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				ice[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int t = 0;
		while (true) {
			
			visit = new boolean[N][M];
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (!visit[i][j] && ice[i][j]>0) {
						BFS(i, j);
						count++;
					}
				}
			}
			if (count>1) {
				System.out.println(t);
				return;
			}
			if (check()) {
				System.out.println(0);
				return;
			}
			melt();
			t++;
			
		}
		
	}

	
	static void BFS(int x, int y) {
		
		visit[x][y] = true;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>M-1) continue;
				if(visit[a][b]) continue;
				if(ice[a][b]<=0) continue;
				q.add(new Node(a, b));
				visit[a][b] = true;
			}
			
		}
		
		
	}

	static void melt() {
		
		tmp = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ice[i][j]<=0) continue;
				int count = 0;
				for (int k = 0; k < 4; k++) {
					int a = i + dr[k];
					int b = j + dc[k];
					if(a<0||a>N-1||b<0||b>M-1) continue;
					if (ice[a][b]<=0) count++;
				}
				tmp[i][j] += count;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ice[i][j] -= tmp[i][j];
			}
		}
		
	}
	
	static boolean check() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(ice[i][j]>0) return false;
			}
		}
		return true;
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