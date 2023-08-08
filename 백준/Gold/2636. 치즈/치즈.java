import java.io.*;
import java.util.*;

public class Main {

	static int N, M, plate[][], dr[] = {-1,0,1,0}, dc[]= {0,1,0,-1}, tmp[][];
	static boolean state;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		plate = new int[N][M];
		tmp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int g = -1;
		while (!state) {
			air(g);
			del(g);
			check();
			g--;
		}
		System.out.println(-1*(g+1));
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j]==1) count++;
			}
		}
		System.out.println(count);
		
	}
	
	static void air(int p) {
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(new Node(0, 0));
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>M-1) continue;
				if (plate[a][b] == p+1 || plate[a][b] == 0) {
					plate[a][b] = p;
					q.add(new Node(a, b));
				}
			}
		}
	}
	
	static void del(int p) {
		for (int i = 0; i < N; i++) {
			tmp[i] = plate[i].clone();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(tmp[i][j]==1 || tmp[i][j]==0) continue;
				for (int k = 0; k < 4; k++) {
					int a = i + dr[k];
					int b = j + dc[k];
					if(a<0||a>N-1||b<0||b>M-1) continue;
					if (tmp[a][b]==1) {
						plate[a][b] = p;
					}
				}
			}
		}
	}
	
	static void check() {
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(plate[i][j]==1) {
					state = false;
					return;
				}
			}
		}
		state = true;
		return;
		
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