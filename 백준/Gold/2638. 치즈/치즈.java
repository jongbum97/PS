import java.io.*;
import java.util.*;

public class Main {
	
	static int dr[]= {-1,0,1,0},dc[]= {0,1,0,-1}, N, M, map[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int k = 2;
		while (true) {	
			if (check(k)) {
				melt(k);
				k++;
			}else {
				break;
			}
		}
		
		bw.write((k-2)+"\n");
		bw.close();
	}
	
	static void melt(int k) {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]!=1) continue;
				int count = 0;
				for (int t = 0; t < 4; t++) {
					int a = i + dr[t];
					int b = j + dc[t];
					if(a<0||a>N-1||b<0||b>M-1) continue;
					if(map[a][b]==k) count++;
				}
				if(count>1) map[i][j] = 0;
			}
		}
		
	}

	static boolean check(int k) {
		boolean state = false;
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(0,0));
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>M-1) continue;
				if(map[a][b]==k) continue;
				if(map[a][b]==1) {
					state = true;
					continue;
				}
				map[a][b] = k;
				q.add(new Node(a, b));
			}
		}
		return state;
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