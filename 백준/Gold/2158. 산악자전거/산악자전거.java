import java.io.*;
import java.util.*;

public class Main {

	static int V, R, C, map[][], dr[]={-1,0,1,0}, dc[]={0,1,0,-1};
	static double time[][], T;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = 1d/V;
		time = new double[R][C];
		map = new int[R][C];
		for(int i=0; i<R; i++){
			Arrays.fill(time[i], 200000000000d);
		}
		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dijkstra();
//		for(int i=0; i<R; i++){
//			System.out.println(Arrays.toString(time[i]));
//		}
		System.out.println(time[R-1][C-1]);
		
		
	}

	static void dijkstra() {
		
		PriorityQueue<Node> queue = new PriorityQueue<>((a,b)->Double.compare(a.cost, b.cost));
		time[0][0] = 0;
		queue.add(new Node(0, 0, T, 0));
		
		while (!queue.isEmpty()) {
			
			Node n = queue.remove();
			
			if(time[n.x][n.y] < n.cost) continue;
			
			for(int i=0; i<4; i++){
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>R-1||b<0||b>C-1) continue;
				if(time[a][b] > n.cost + n.t) {
					double w = Math.pow(2, map[a][b]-map[n.x][n.y]);
					time[a][b] = n.cost + n.t;
					queue.add(new Node(a, b, n.t*w, n.cost + n.t));
				}
			}
			
		}
		
		
	}
}
class Node{
	int x;
	int y;
	double cost;
	double t;
	Node(int x, int y, double t, double cost){
		this.x = x;
		this.y = y;
		this.t = t;
		this.cost = cost;
	}
}