import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, K, map[][][], dir[], pri[][][], dr[]= {-1,1,0,0}, dc[]= {0,0,-1,1}, tmp[][][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[3][N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				map[0][i][j] = a;
				if (a!=0) {
					map[1][i][j] = K;
					map[2][i][j] = a;
				}
			}
		}
		dir = new int[M+1];
		pri = new int[M+1][4][4];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= M; i++) {
			dir[i] = Integer.parseInt(st.nextToken())-1;
		}
		for (int i = 1; i <= M; i++) {
			for (int j = 0; j < 4; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 4; k++) {
					pri[i][j][k] = Integer.parseInt(st.nextToken())-1;
				}
			}
		}
		
		int cnt = 0;
		outer : while (++cnt<=1000) {
			
//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[0][i])+"   "+Arrays.toString(map[1][i])+"   "+Arrays.toString(map[2][i]));
//			}System.out.println();
			
			tmp = new int[2][N][N];
			for (int i = 0; i < N; i++) {
				tmp[1][i] = map[1][i].clone();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[0][i][j]!=0) move(i, j);
				}
			}
			
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[i][j];
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[1][i][j]>0) map[1][i][j]--;
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[0][i][j]>1) continue outer;
				}
			}
			break;
		}
		
		if (cnt>1000) {
			bw.write(-1+"\n");
		}else {
			bw.write(cnt+"\n");
		}
		
		bw.close();
	

	
	}

	static void move(int x, int y) {
		
		int k = map[0][x][y];
		int prio[] = pri[k][dir[k]];
		boolean flag = false;
		for (int i = 0; i < 4; i++) {
			int a = x + dr[prio[i]];
			int b = y + dc[prio[i]];
			if(a<0||a>N-1||b<0||b>N-1) continue;
			if(map[1][a][b]!=0) continue;
			if(tmp[0][a][b]==0||tmp[0][a][b]>k) {
				tmp[1][a][b] = K+1;
				map[2][a][b] = k;
				tmp[0][a][b] = k;
				dir[k] = prio[i];
			}
			flag = true;
			break;
		}
		if (!flag) {
			for (int i = 0; i < 4; i++) {
				int a = x + dr[prio[i]];
				int b = y + dc[prio[i]];
				if(a<0||a>N-1||b<0||b>N-1) continue;
				if(map[2][a][b]==k) {
					tmp[1][a][b] = K+1;
					tmp[0][a][b] = k;
					dir[k] = prio[i];
					break;
				}
			}
		}
	}


}