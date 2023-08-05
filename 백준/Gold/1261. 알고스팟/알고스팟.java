import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans[][], dr[]= {-1, 0, 1, 0}, dc[]= {0, 1, 0, -1};
	static char[][] miro;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		miro = new char[M][];
		ans = new int[M][N];
		for (int i = 0; i < M; i++) {
			miro[i] = br.readLine().toCharArray();
			Arrays.fill(ans[i], Integer.MAX_VALUE);
		}
		
		dijkstra();
		
		bw.write(ans[M-1][N-1]+"\n");
		bw.close();
	}
	
	
	static void dijkstra() {
		
		PriorityQueue<Node> q = new PriorityQueue<>((o1,o2)->Integer.compare(o1.count, o2.count));
		q.add(new Node(0, 0, 0));
		ans[0][0] = 0;
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			if (ans[n.x][n.y] < n.count) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int x = n.x + dr[i];
				int y = n.y + dc[i];
				if (x<0||x>M-1||y<0||y>N-1) continue;
				if (miro[x][y]=='0') {
					if (ans[x][y] > n.count) {
						ans[x][y] = n.count;
						q.add(new Node(x, y, ans[x][y]));
					}
				}else {
					if (ans[x][y] > n.count+1) {
						ans[x][y] = n.count+1;
						q.add(new Node(x, y, ans[x][y]));
					}
				}
			}
			
			
			
		}
		
		
		
		
	}
	


}

class Node{
	int x;
	int y;
	int count;
	Node(int x, int y, int count){
		this.x = x;
		this.y = y;
		this.count = count;
	}
}