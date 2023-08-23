import java.io.*;
import java.util.*;

public class Main {

	static int N, parent[];
	static double star[][], line[][], ans;
	static boolean visit[];


	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==1) {
			System.out.println("0.00");
			return;
		}
		star = new double[N+1][2];
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			star[i][0] = Double.parseDouble(st.nextToken());
			star[i][1] = Double.parseDouble(st.nextToken());
		}
		line = new double[N][N];
		visit = new boolean[N+1];
		ans = 0;
		
		PriorityQueue<Edge> q = new PriorityQueue<>();
		visit[1] = true;
		for (int i = 2; i <= N; i++) {
			q.add(new Edge(1, i, dis(1, i)));
		}
		
		while (!q.isEmpty()) {
			
			Edge e = q.remove();
			if (visit[e.y]) continue;
			ans += e.cost;
			visit[e.y] = true;
			
			for (int i = 1; i <= N; i++) {
				if (!visit[i]) {
					q.add(new Edge(e.y, i, dis(e.y, i)));
				}
			}
			
		}
		
		System.out.printf("%.2f\n",ans);
	
	}
	
	static double dis(int x, int y) {
		return Math.sqrt(Math.pow(star[x][0]-star[y][0], 2)+Math.pow(star[x][1]-star[y][1], 2));
	}


}

class Edge implements Comparable<Edge>{
	int x;
	int y;
	double cost;
	
	Edge(int  x, int y, double cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	
	@Override
	public int compareTo(Edge o) {
		return (int)(this.cost*1000 - o.cost*1000);
	}
}