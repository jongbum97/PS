import java.io.*;
import java.util.*;

public class Main {
	
	static int V, ans, X;
	static List<Node> line[];
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		line = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			line[i] = new ArrayList<>();
		}
		for (int i = 1; i <= V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			while (true) {
				int a = Integer.parseInt(st.nextToken());
				if(a == -1) break;
				int b = Integer.parseInt(st.nextToken());
				line[k].add(new Node(a, b));
			}
		}
		ans = 0;
		visit = new boolean[V+1];
		DFS(1, 0);
		visit = new boolean[V+1];
		DFS(X, 0);
			
		System.out.println(ans);
		
	}

	static void DFS(int x, int sum) {
		
		visit[x] = true;
		if(ans<sum) {
			ans = sum;
			X = x;
		}
		
		for (int i = 0; i < line[x].size(); i++) {
			Node n = line[x].get(i);
			if(visit[n.x]) continue;
			DFS(n.x, sum+n.cost);
		}
		
	}
}

class Node{
	int x;
	int cost;
	Node(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}