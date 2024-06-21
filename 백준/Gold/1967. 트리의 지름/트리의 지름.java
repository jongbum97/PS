import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt, ans;
	static List<int[]>[] line;
	static boolean visit[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		line = new List[N+1];
		for (int i=1; i<=N; i++){
			line[i] = new ArrayList<>();
		}

		for (int i=0; i<N-1; i++){
			String[] tmp = br.readLine().split(" ");
			int a = Integer.parseInt(tmp[0]);
			int b = Integer.parseInt(tmp[1]);
			int cost = Integer.parseInt(tmp[2]);
			line[a].add(new int[]{b, cost});
			line[b].add(new int[]{a, cost});
		}
		
		for(int i=1; i<=N; i++){
			if(line[i].size() == 1){
				visit = new boolean[N+1];
				visit[i] = true;
				cnt = 0;
				dfs(i);
			}
		}

		System.out.println(ans);

	}

	private static void dfs(int i) {
		boolean flag = false;

		for (int[] n : line[i]){
			if(visit[n[0]]) continue;
			flag = true;
			cnt += n[1];
			visit[n[0]] = true;
			dfs(n[0]);
			cnt -= n[1];
		}

		if(!flag)
			ans = Math.max(ans, cnt);
	}

}
