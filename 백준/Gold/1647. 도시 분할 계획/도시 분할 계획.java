import java.io.*;
import java.util.*;

public class Main {

	static int N, M, parent[];
	static List<Node> line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for (int i=0; i<=N; i++){
			parent[i] = i;
		}

		line = new ArrayList<>();
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			line.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}

		line.sort((a,b) -> a.cost - b.cost);

		int cnt = 0;
		int ans = 0;
		for(Node n : line){
			int x = find(n.x);
			int y = find(n.y);
			if(x == y) continue;
			if(cnt == N-2) break;
			
			union(x, y);
			cnt++;
			ans += n.cost;
		}

		System.out.println(ans);

	}

	static void union(int x, int y){
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
	
	static int find(int n){
		if(n == parent[n]) return n;
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
