import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, map[][], dr[]={-1, 0, 1, 0}, dc[]={0, 1, 0, -1}, parent[];
	static List<int[]> line;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 2;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==1) dfs(i, j, cnt++);
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println("cnt: "+cnt);

		
		line = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]==0) continue;
				for (int k = 0; k < 2; k++) {
					int a = i + dr[k];
					int b = j + dc[k];
					if(a<0||a>N-1||b<0||b>M-1) continue;
					if(map[a][b]==0) {
						int x = map[i][j];
						int y = 0;
						int c = 2;
						while (true) {
							a = i + c*dr[k];
							b = j + c*dc[k];
							if(a<0||a>N-1||b<0||b>M-1) {
								c = 2;
								break;
							}
							if(map[a][b]==0) {
								c++; continue;
							}else {
								y = map[a][b];
								break;
							}
						}
						if(c==2) continue;
						else {
							boolean bb = false;
							for (int l = 0; l < line.size(); l++) {
								int[] tmp = line.get(l);
								if((tmp[0]==x&&tmp[1]==y)||(tmp[0]==y&&tmp[1]==x)) {
									if(tmp[2]>c-1) {
										line.get(l)[2] = c-1;
									}
									bb = true;
								}
							}
							if(!bb) line.add(new int[] {x, y, c-1});
						}
					}
				}
			}
		}
		
		parent = new int[cnt];
		for (int i = 0; i < cnt; i++) {
			parent[i] = i;
		}
		Collections.sort(line, (a,b)->a[2]-b[2]);
		
//		for (int i = 0; i < line.size(); i++) {
//			System.out.println(line.get(i)[0]+","+line.get(i)[1]+" = "+line.get(i)[2]);
//		}
		
		int c = 0;
		int ans = 0;
		for (int i = 0; i < cnt-3; i++) {
			int[] tmp = null;
			try {
				tmp = line.get(c);
			} catch (Exception e) {
				ans = -1;
				break;
			}
			int x = tmp[0];
			int y = tmp[1];
			int cost = tmp[2];
			
			int a = find(x);
			int b = find(y);
			
			if(a!=b) {
				union(a, b);
				ans += cost;
			}else {
				i--;
			}
			c++;
		}
		
		System.out.println(ans);
		
	}
	
	static void union(int x, int y) {
		x = find(x);
		y = find(y);
		parent[x] = y;
	}
	
	static int find(int x) {
		if(parent[x]==x) return x;
		return parent[x] = find(parent[x]);
	}
	
	static void dfs(int x, int y, int cnt) {
		map[x][y] = cnt;
		for (int i = 0; i < 4; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0||a>N-1||b<0||b>M-1) continue;
			if(map[a][b]!=1) continue;
			dfs(a, b, cnt);
		}
	}
}
