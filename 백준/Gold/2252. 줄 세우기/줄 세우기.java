import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] list1, list2;
	static List<Integer> roots;
	static boolean visit[];
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list1 = new ArrayList[N+1];
		list2 = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list1[a].add(b);
			list2[b].add(a);
		}
		
		visit = new boolean[N+1];
		roots = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (!visit[i]) root(i);
		}
		
		
		visit = new boolean[N+1];
		for (int e : roots) {
			DFS(e);
		}
		
		bw.close();
		
		
	}
	

	
	static void DFS(int x) throws IOException {
		
		visit[x] = true;
		
		for (int e : list2[x]) {
			if (!visit[e]) {
				DFS(e);
			}
		}
		
		bw.write(x+" ");
		
	}

	static void root(int x) {
		
		visit[x] = true;
		
		if (list1[x].size()==0) {
			roots.add(x);
		}
		
		for (int e : list1[x]) {
			if(visit[e]) continue;
			root(e);
		}
		
	}
	
	
}