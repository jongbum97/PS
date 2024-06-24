import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Node>[] line;

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

			line = new ArrayList[N];
			for (int i=0; i<N; i++){
				line[i] = new ArrayList<>();
			}
			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				line[a].add(new Node(b, c));
				line[b].add(new Node(a, c));
				sum += c;
			}

			sb.append(sum-prim()).append("\n");

		}

		System.out.println(sb);

	}

	static int prim(){
		boolean[] visit = new boolean[N];
		int ans = 0;

		Queue<Node> q = new PriorityQueue<>((a,b) -> a.cost - b.cost);
		q.add(new Node(0, 0));

		while (!q.isEmpty()){

			Node n = q.remove();
			if(visit[n.y]) continue;

			visit[n.y] = true;
			ans += n.cost;

			for(Node nn : line[n.y]){
				if(visit[nn.y]) continue;
				q.add(nn);
			}

		}

		return ans;

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
