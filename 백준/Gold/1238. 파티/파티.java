import java.io.*;
import java.util.*;

public class Main {

	static int N, M, X, go[], back[], tmp[], ans;
	static List<Node>[] list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
		}
		go = new int[N+1];
		tmp = new int[N+1];
		for (int i = 1; i <= N; i++) {
			Arrays.fill(tmp, Integer.MAX_VALUE);
			dijkstraGo(i);
		}
		
		back = new int[N+1];
		Arrays.fill(back, Integer.MAX_VALUE);
		dijkstraBack(X);
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, go[i]+back[i]);
		}
		bw.write(ans+"\n");
		bw.close();
	}
	
	
	static void dijkstraGo(int x) {
		
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
		q.add(new Node(x, 0));
		tmp[x] = 0;
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			if (n.x==X) {
				go[x] = tmp[X];
				return;
			}
			
			for (int i = 0; i < list[n.x].size(); i++) {
				int a = list[n.x].get(i).x;
				int c = list[n.x].get(i).cost;
				if (tmp[a] > n.cost + c) {
					tmp[a] = n.cost + c;
					q.add(new Node(a, tmp[a]));
				}
			}
		}
	}
	
	static void dijkstraBack(int x) {
		PriorityQueue<Node> q = new PriorityQueue<>((a,b)->Integer.compare(a.cost, b.cost));
		q.add(new Node(x, 0));
		back[x] = 0;
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			for (int i = 0; i < list[n.x].size(); i++) {
				int a = list[n.x].get(i).x;
				int c = list[n.x].get(i).cost;
				if (back[a] > n.cost + c) {
					back[a] = n.cost + c;
					q.add(new Node(a, back[a]));
				}
			}	
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