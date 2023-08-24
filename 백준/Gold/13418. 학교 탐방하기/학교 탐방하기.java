import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans;
	static List<Node>[] list;
	static boolean visit[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new LinkedList[N+1];
		for (int i = 0; i <= N; i++) {
			list[i] = new LinkedList<>();
		}
		for (int i = 0; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b,-1*(c-1)));
			list[b].add(new Node(a,-1*(c-1)));
		}

		
		visit = new boolean[N+1];
		int min = 0;
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->a.cost-b.cost);
		for (int i = 0; i < list[0].size(); i++) {
			q.add(list[0].get(i));
		}
		visit[0] = true;
		int cnt = 0;
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			if(visit[n.y]) continue;
			visit[n.y] = true;
			min += n.cost;
			for (Node node : list[n.y]) {
				if(visit[node.y]) continue;
				q.add(node);
			}
			if(++cnt==N) break;
		}
		
		visit = new boolean[N+1];
		int max = 0;
		PriorityQueue<Node> q2 = new PriorityQueue<>((a,b)->b.cost-a.cost);
		for (int i = 0; i < list[0].size(); i++) {
			q2.add(list[0].get(i));
		}
		visit[0] = true;
		cnt = 0;
		while (!q2.isEmpty()) {
			
			Node n = q2.remove();
			if(visit[n.y]) continue;
			visit[n.y] = true;
			max += n.cost;
			for (Node node : list[n.y]) {
				if(visit[node.y]) continue;
				q2.add(node);
			}
			if(++cnt==N) break;
		}
		
		System.out.println(max*max-min*min);
	
	}
	
}
class Node{
	int y;
	int cost;
	Node(int y, int cost){
		this.y = y;
		this.cost = cost;
	}
}