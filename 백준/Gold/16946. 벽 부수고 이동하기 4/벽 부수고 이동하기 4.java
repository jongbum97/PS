import java.io.*;
import java.util.*;

public class Main {

	static final int dr[] = {-1, 0, 1, 0}, dc[] = {0, 1 ,0, -1};
	static int N, M, map[][], dis[][], num[][], cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		map = new int[N][M];
		dis = new int[N][M];
		num = new int[N][M];
		for(int i=0; i<N; i++){
			String data = br.readLine();
			for(int j=0; j<M; j++){
				map[i][j] = dis[i][j] = num[i][j] = Integer.parseInt(data.charAt(j)+"");
			}
		}

		int c = 2;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(dis[i][j] == 0) {
					cnt = 1;
					count(i, j, c++);
					measure(i, j, cnt);
				}
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] == 1){
					int sum = 1;
					int[] tmp = new int[4];
					outer: for(int k=0; k<4; k++){
						int a = i + dr[k];
						int b = j + dc[k];
						if(a<0 || a>N-1 || b<0 || b>M-1) continue;
						if(map[a][b] == 1) continue;
						for(int l=0; l<k; l++){
							if(tmp[l] == num[a][b]) continue outer;
						}
						tmp[k] = num[a][b];
						sum += dis[a][b];
					}
					dis[i][j] = sum%10;
				}
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(map[i][j] == 0) sb.append(0);
				else sb.append(dis[i][j]);
			}
			sb.append("\n");
		}

		System.out.println(sb);


	}

	static void count(int x, int y, int c){
		num[x][y] = c;

		for(int i=0; i<4; i++){
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0 || a>N-1 || b<0 || b>M-1) continue;
			if(num[a][b] == 0) {
				cnt++;
				count(a, b, c);
			}
		};

	}

	static void measure(int x, int y, int c){
		dis[x][y] = c;

		for(int i=0; i<4; i++){
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0 || a>N-1 || b<0 || b>M-1) continue;
			if(dis[a][b] == 0) {
				measure(a, b, c);
			}
		};

	}

}
