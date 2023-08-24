import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans[];
	static List<Node>[] list;
	static boolean visit[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();
		list = new LinkedList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(a, b, c));
			list[b].add(new Node(b, a, c));
		}

		ans = new int[N+1];
		Arrays.fill(ans, Integer.MAX_VALUE);
		ans[1] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
		q.add(new Node(0, 1, 0));
		sb.append(N-1+"\n");
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			if(ans[n.y] < n.cost) continue;
			
			if(n.x!=0) sb.append(n.x).append(" ").append(n.y).append("\n");
			for (Node node : list[n.y]) {
				if(ans[node.y] > n.cost+node.cost) {
					ans[node.y] = n.cost+node.cost;
					q.add(new Node(node.x, node.y, n.cost+node.cost));
				}
			}
			
		}
		bw.write(sb.toString()+"\n");
		bw.close();
		
	
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