import java.io.*;
import java.util.*;

public class Main {

	static int W, H, ans[][], dr[]={-1,0,1,0},dc[]= {0,1,0,-1},a,b,c,d;
	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new char[H][W];
		ans = new int[H][W];
		for (int i = 0; i < H; i++) {
			Arrays.fill(ans[i], Integer.MAX_VALUE);
			map[i] = br.readLine().toCharArray();
		}
		int count=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (map[i][j]=='C') {
					if (count++==0) {
						a=i;b=j;
					}else {
						c=i;d=j;
					}
				}
			}
		}
		
		dijkstra(a,b);
		

	}

	static void dijkstra(int x, int y) {
		
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
		q.add(new Node(x, y, -1, 0));
		ans[x][y] = 0;
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			if (n.x==c && n.y==d) {
				System.out.println(n.cost);
				return;
			}
			
			if (ans[n.x][n.y] < n.cost) {
				continue;
			}
			
			for (int i = 0; i < 4; i++) {
				int u = n.x + dr[i];
				int v = n.y + dc[i];
				if(u<0||u>H-1||v<0||v>W-1) continue;
				if(map[u][v]=='*') continue;
				if (n.state==i || n.state==-1) {
					if (ans[u][v] >= n.cost) {
						ans[u][v] = n.cost;
						q.add(new Node(u, v, i, ans[u][v]));
					}
				}else {
					if (ans[u][v] > n.cost + 1) {
						ans[u][v] = n.cost + 1;
						q.add(new Node(u, v, i, ans[u][v]));
					}
				}
			}
		}	
	}
}

class Node{
	int x;
	int y;
	int state;
	int cost;
	Node(int x, int y, int state, int cost) {
		this.x = x;
		this.y = y;
		this.state = state;
		this.cost = cost;
	}
	
}