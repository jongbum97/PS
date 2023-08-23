import java.io.*;
import java.util.*;

public class Main {

	static int N, M, parent[], ans;
	static char MW[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		MW = new char[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			MW[i] = st.nextToken().charAt(0);
		}
		make();
		PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[2]-b[2]);
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			q.add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		ans = 0;
		int cnt = 0;
		while (cnt<N-1) {
			if(q.isEmpty()) {
				ans = -1;
				break;
			}
			int[] tmp = q.remove();
			
			if(find(tmp[0])!=find(tmp[1]) && MW[tmp[0]]!=MW[tmp[1]]) {
				union(tmp[0], tmp[1]);
				ans += tmp[2];
				cnt++;
			}
		}
		
		System.out.println(ans);
	
	}
	
	static void make() {
		parent = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[y] = x;
	}
	
}