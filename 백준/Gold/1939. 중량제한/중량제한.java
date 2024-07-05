import java.io.*;
import java.util.*;

public class Main {

	static int N, M, start, end, parent[];
	static Queue<Node> q;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<>();
		while(--M >= 0){
			st = new StringTokenizer(br.readLine());
			q.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		parent = new int[N+1];
		for(int i=1; i<N; i++){
			parent[i] = i;
		}

		int ans = Integer.MAX_VALUE;
		while(find(start) != find(end)){

			Node n = q.remove();
			if(find(n.x) != find(n.y)){
				union(n.x, n.y);
				ans = Math.min(ans, n.cost);
			}

		}

		System.out.println(ans);

	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);
		parent[a] = b;
	}

	static int find(int n){
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}

	static class Node implements Comparable<Node>{
		int x;
		int y;
		int cost;
		Node(int x, int y, int cost){
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o){
			return o.cost - this.cost;
		}
	}




}
