import java.io.*;
import java.util.*;

public class Main {
	
	static int N, flag, dis[];
	static boolean visit[], ans[], state;
	static List<Integer>[] list;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		visit = new boolean[N+1];
		ans = new boolean[N+1];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		flag = -10000;
		for (int i = 1; i <= N; i++) {
			if(list[i].size()>2) {
				flag = i;
				seek(-1, -1, i);
				if(flag!=i) {
					visit = new boolean[N+1];
					state= false;
					flag *= -1;
					seek(-1, -1, flag);
				}
				break;
			}
		}
		dis = new int[N+1];
		visit = new boolean[N+1];
//		System.out.println(Arrays.toString(ans));
		if(flag==-10000) {
			
		}else {
			BFS(flag, 0);
		}
		
		for (int i = 1; i <= N; i++) {
			bw.write(dis[i]+" ");
		}
		
		bw.close();
		
	}

	static void BFS(int x, int c) {
		dis[x] = 0;
		visit[x] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(x);
		
		while (!q.isEmpty()) {
			
			int n = q.remove();
//			System.out.println(n+"*");
			
			for (int i = 0; i < list[n].size(); i++) {
				int a = list[n].get(i);
				if(visit[a]) continue;
				if (ans[a]) {
					dis[a] = 0;
				}else {
					dis[a] = dis[n]+1;
				}
				visit[a] = true;
				q.add(a);
			}
			
			
		}
		
		
	}


	
	static void seek(int x, int y, int z) {
//		System.out.println(z);
		if(state) return;
		if(visit[z]) {
			if(z!=x) {
				if(flag!=z) {
					flag = -1*z;
//					System.out.println(flag+"**");
				}else {
					ans = visit.clone();
				}
				state = true;
			}
			return;
		}
		visit[z] = true;
		for (int i = 0; i < list[z].size(); i++) {
			if(state) return;
			int a = list[z].get(i);
			seek(y, z, a);
		}
		visit[z] = false;
	}
}