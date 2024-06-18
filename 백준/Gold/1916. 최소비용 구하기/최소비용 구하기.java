import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Node>[] line;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		line = new ArrayList[N+1];
		for (int i=1; i<=N; i++){
			line[i] = new ArrayList<>();
		}

		for(int i=0; i<M; i++){
			String[] tmp = br.readLine().split(" ");
			line[Integer.parseInt(tmp[0])].add(new Node(Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2])));
		}

		String[] tmp = br.readLine().split(" ");

		int ans = bfs(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]));

		System.out.println(ans);
		
	}

	public static int bfs(int start, int end){

		int[] cost = new int[N+1];
		Arrays.fill(cost, Integer.MAX_VALUE);

		Queue<Node> q = new PriorityQueue<>((a,b) -> Integer.compare(a.cost, b.cost));
		q.add(new Node(start, 0));
		cost[start] = 0;

		while (!q.isEmpty()){
//			System.out.println(Arrays.toString(cost));

			Node n = q.poll();
            if(n.y == end) return cost[end];
			if(cost[n.y] < n.cost) continue;

			for(Node nn : line[n.y]){
				if(cost[nn.y] > n.cost + nn.cost){
					cost[nn.y] = n.cost + nn.cost;
					q.add(new Node(nn.y, cost[nn.y]));
				}
			}

		}

		return cost[end];

	}

}

class Node{
	int y;
	int cost;

	public Node(int y, int cost){
		this.y = y;
		this.cost = cost;
	}

}