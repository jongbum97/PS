import java.io.*;
import java.util.*;

public class Main {

	static int N, M, parent[];
	static List<Node> line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		line = new ArrayList<>();
		for(int i=1; i<=N; i++){
			parent[i] = i;
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == b) continue;
			line.add(new Node(a, b, c));
		}
		line.sort((a, b) -> a.cost - b.cost);

		int cnt = 0;
		int ans = 0;
        for (Node n : line) {
            int a = find(n.x);
            int b = find(n.y);
            if (a == b) continue;

            union(a, b);
            cnt++;
			ans += n.cost;
            if (cnt == N-1) break;
        }
		
		System.out.println(ans);

	}

	static void union(int x, int y){
		x = find(x);
		y = find(y);
		parent[x] = find(y);
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
