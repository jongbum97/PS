import java.io.*;
import java.util.*;

public class Main {

	static int V, E;
	static List<Integer>[] list;
	static byte visit[];
	static boolean state;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			list = new ArrayList[V + 1];
			for (int i = 1; i <= V; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			state = false;
			visit = new byte[V+1];
			for (int i = 1; i <= V; i++) {
				if (visit[i]==0) {
					visit[i] = 1;
					DFS(i);
				}
			}
			if (state) {
				bw.write("NO\n");
			}else {
				bw.write("YES\n");
			}
		}
		bw.close();

	}

	static void DFS(int x) {
		
		if (state) {
			return;
		}

		for (int e : list[x]) {
			if (visit[e]*visit[x]==1) {
				state = true;
				return;
			}
			if (visit[e]!=0) continue;
			
			if (visit[x]==1) {
				visit[e] = -1;
			}else {
				visit[e] = 1;
			}
			DFS(e);
		}
	}

}


