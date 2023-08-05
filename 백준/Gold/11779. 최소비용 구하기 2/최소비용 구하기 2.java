import java.io.*;
import java.util.*;

public class Main {

	static int N, M, start, arrive, dp[];
	static List<Node>[] list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		StringTokenizer st; 
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new Node(b, c));
		}
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		arrive = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dijkstra(start);
//		bw.write(ans+"\n");
		bw.close();
	}

	static void dijkstra(int x) {
		
		dp[x] = 0;
		PriorityQueue<Node> q = new PriorityQueue<>((a, b)->Integer.compare(a.cost, b.cost)); 
		List<Integer> path = new ArrayList<>();
		path.add(x);
		q.add(new Node(x, 0, path));
		
		while (!q.isEmpty()) {
			
			Node n = q.remove();
			
			if (n.x==arrive) {
				System.out.println(n.cost);
				System.out.println(n.path.size());
				for (Integer integer : n.path) {
					System.out.print(integer+" ");
				}
				return;
			}
			
			for (int i = 0; i < list[n.x].size(); i++) {
				
				Node nn = list[n.x].get(i);
				
				if (dp[nn.x] > n.cost + nn.cost) {
					dp[nn.x] =  n.cost + nn.cost;
					List<Integer> nnn = new ArrayList<>(n.path);
					nnn.add(nn.x);
					q.add(new Node(nn.x, dp[nn.x], nnn));
				}
				
				
			}
			
			
			
			
		}
		
		
	}
	
	
	

}

class Node{
	int x;
	int cost;
	List<Integer> path = new ArrayList<>();
	Node(int x, int cost, List<Integer> list){
		this.x = x;
		this.cost = cost;
		this.path = list;
	}
	Node(int x, int cost){
		this.x = x;
		this.cost = cost;
	}
}