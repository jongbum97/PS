import java.io.*;
import java.util.*;

public class Main {

	static int N, map[][], dr[]={-1,0,1,0}, dc[]={0,1,0,-1}, ans;
	static boolean visit[][], state;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int k = 100000;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					BFS(i, j, k);
					k += 100000;
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		BBFS();
		
		bw.write(ans+"\n");
		
		bw.close();
		
	}
	
	
	static void BBFS() {
		
		Queue<Node> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]!=0) {
					q.add(new Node(i, j));
				}
			}
		}
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>N-1) continue;
				if(map[a][b]==0) {
					map[a][b] = map[n.x][n.y] + 1;
					q.add(new Node(a, b));
					continue;
				}
				if (Math.abs(map[n.x][n.y]-map[a][b])>50000) {
					ans = Math.min(ans, (map[n.x][n.y]%100000) + (map[a][b]%100000));
				}
			}
		}
	}
	
	static void BFS(int x, int y, int k) {
		map[x][y] = k;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(x, y));
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>N-1) continue;
				if(map[a][b]==1) {
					map[a][b] = k;
					q.add(new Node(a, b));
				}
			}
		}
	}
}
class Node{
	int x;
	int y;
	int c;
	int k;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}