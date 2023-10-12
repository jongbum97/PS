import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, from[], dis[], min, ans, INF=1000000000;
	static List<int[]>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		int a, b, c;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b, c});
			list[b].add(new int[] {a, c});
		}
		from = new int[N+1];
		dis = new int[N+1];
		Arrays.fill(dis, INF);
		
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
		queue.add(new int[] {1, 0});
		dis[1] = 0;
		
//		System.out.println(Arrays.toString(dis));
//		System.out.println(Arrays.toString(from));
//		System.out.println();
		while (!queue.isEmpty()) {
			
			int[] n = queue.remove();
			int x = n[0];
			int cost = n[1];
			if(dis[x] < cost) continue;
			
			for (int[] e : list[x]) {
				if(dis[e[0]] > cost + e[1]) {
					queue.add(new int[] {e[0], cost + e[1]});
					dis[e[0]] = cost + e[1];
					from[e[0]] = x;
				}
			}
			
//			System.out.println(Arrays.toString(dis));
//			System.out.println(Arrays.toString(from));
//			System.out.println();
		}
		
		min = dis[N];
		int idx = N;
		
		while (idx!=0) {
			int x = from[idx];
			int y = idx;
			
			dijkstra(x, y);
			
			ans = Math.max(ans, dis[N]);
			if(ans==INF) {
				ans = min-1;
				break;
			}
			
			idx = from[idx];
			
		}
		
		System.out.println(ans-min);
		
	}
	
	static void dijkstra(int a, int b) {
		dis = new int[N+1];
		Arrays.fill(dis, INF);
		PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2)->o1[1]-o2[1]);
		queue.add(new int[] {1, 0});
		dis[1] = 0;
		
		while (!queue.isEmpty()) {
			
			int[] n = queue.remove();
			int x = n[0];
			int cost = n[1];
			if(dis[x] < cost) continue;
			
			for (int[] e : list[x]) {
				if((x==a&&e[0]==b)||(x==b&&e[0]==a)) continue;
				if(dis[e[0]] > cost + e[1]) {
					queue.add(new int[] {e[0], cost + e[1]});
					dis[e[0]] = cost + e[1];
				}
			}
			
		}
	}
	
	
}