import java.io.*;
import java.util.*;

public class Main {

	static int N, M, parent[];
	static List<Node> line;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (true){
			int sum = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			if(N == 0 && M == 0) break;

			line = new ArrayList<>();
			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				line.add(new Node(a, b, c));
				sum += c;
			}

			line.sort((a,b) -> a.cost - b.cost);

			parent = new int[N];
			for(int i=0; i<N; i++){
				parent[i] = i;
			}
			int ans = 0;
			int cnt = 0;
			for(Node n : line){
				int a = find(n.x);
				int b = find(n.y);
				if(a == b) continue;

				union(a, b);
				ans += n.cost;
				cnt++;
				if(cnt == N-1) break;
			}

			sb.append(sum-ans).append("\n");

		}

		System.out.println(sb);

	}

	static void union(int x, int y){
		x = find(x);
		y = find(y);
		parent[x] = y;
	}

	static int find(int n){
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}


}
class Node{
	int x;
	int y;
	int cost;
	Node(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}
