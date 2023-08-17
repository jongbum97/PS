import java.io.*;
import java.util.*;

public class Main {

	static int N, line[], count, flag;
	static boolean visit[], ans[], check[];

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 0; tc < t; tc++) {
			N = Integer.parseInt(br.readLine());
			line = new int[N+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				line[i] = Integer.parseInt(st.nextToken());
			}
			
			visit = new boolean[N+1];
			ans = new boolean[N+1];
			check = new boolean[N+1];
			for (int i = 1; i <= N; i++) {
				if(!ans[i]) {
					flag = i;
					visit[i] = true;
					check[i] = true;
					DFS(line[i]);
					visit[i] = false;
					if(flag<0) mark(-1*flag);
				}
			}
			
			count = 0;
			for (int i = 1; i <= N; i++) {
				if(!ans[i]) count++;
			}
			bw.write(count+"\n");
		}
			bw.close();
	}

	static void DFS(int x) {
		if(ans[x]) return;
		if(visit[x]) {
			flag = -1*x;
			return;
		}
		if(check[x]) return;
		
		check[x] = true;
		visit[x] = true;
		DFS(line[x]);
		visit[x] = false;
	}
	
	static void mark(int x) {
		if(ans[x]) return;
		ans[x] = true;
		mark(line[x]);
	}
	
}