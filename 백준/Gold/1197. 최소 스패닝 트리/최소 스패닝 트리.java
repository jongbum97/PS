import java.io.*;
import java.util.*;

public class Main {

	static int V, E, ans;
	static List<int[]>[] list;
	static boolean visit[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		visit = new boolean[V+1];
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
		queue.add(new int[] {1, 0});
		
		while (!queue.isEmpty()) {
			int[] tmp = queue.remove();
			
			if(visit[tmp[0]]) continue;
			visit[tmp[0]] = true;
			ans += tmp[1];
			
			for (int[] e : list[tmp[0]]) {
				if(!visit[e[0]]) queue.add(e);
			}
			
		}
		
		System.out.println(ans);
		
	}
	

}
