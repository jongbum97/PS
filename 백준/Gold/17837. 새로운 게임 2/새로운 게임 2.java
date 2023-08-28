import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K, map[][], dir[], dr[]= {0,0,-1,1}, dc[]= {1,-1,0,0};
	static List<Integer>[][] list;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		list = new ArrayList[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				list[i][j] = new ArrayList<>();
			}
		}
		dir = new int[K+1];
		for (int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			dir[i] = c;
			list[a][b].add(i);
		}
		
		
		for (int p = 1; p <= 1000; p++) {
			outer : for (int t = 1; t <= K; t++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(list[i][j].size()>3) {
							bw.write(p+"\n");
							bw.close();
							return;
						}
						for (int k = 0; k < list[i][j].size(); k++) {
							if(list[i][j].get(k)==t) {
								int a = i + dr[dir[t]];
								int b = j + dc[dir[t]];
								if((a<0||a>N-1||b<0||b>N-1)||map[a][b]==2) {
									dir[t] += (dir[t]%2==0)? 1:-1;
									a = i + dr[dir[t]];
									b = j + dc[dir[t]];
									if((a<0||a>N-1||b<0||b>N-1)||map[a][b]==2) {
										continue outer;
									}
								}
								move(t, i, j);
								continue outer;
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(list[i][j].size()>3) {
						bw.write(p+"\n");
						bw.close();
						return;
					}
				}
			}
		}
		
		bw.write(-1+"\n");
		bw.close();
	

	
	}

	static void move(int t, int x, int y) {
		int a = x + dr[dir[t]];
		int b = y + dc[dir[t]];
		int idx = list[x][y].indexOf(t);
		if (map[a][b]==0) {
			for (int i = idx; i < list[x][y].size();) {
				int k = list[x][y].remove(i);
				list[a][b].add(k);
			}
		}else {
			for (int i = list[x][y].size()-1; i >= idx; i--) {
				int k =list[x][y].remove(i);
				list[a][b].add(k);
			}
		}
		
	}
	
}