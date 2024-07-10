import java.io.*;
import java.util.*;

public class Main {

	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int N, M, K, taxi[], dist[][][][], ans, guest[][], destination[][];
	static boolean isWall[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		isWall = new boolean[N][N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				isWall[i][j] = Integer.parseInt(st.nextToken()) == 1;
			}
		}
		taxi = new int[2];
		st = new StringTokenizer(br.readLine());
		taxi[0] = Integer.parseInt(st.nextToken())-1;
		taxi[1] = Integer.parseInt(st.nextToken())-1;

		bfs();
//		print();
		guest = new int[M][];
		destination = new int[M][];
		for(int t=0; t<M; t++){
			st = new StringTokenizer(br.readLine());
			guest[t] = new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0};
			destination[t] = new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1, 0};
		}


		for(int i=0; i<M; i++){
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=0; j<M; j++){
				if(guest[j][2] == 1) continue;
				int go = dist[taxi[0]][taxi[1]][guest[j][0]][guest[j][1]];
				if(min > go){
					min = go;
					idx = j;
				}else if(min == go){
					if(guest[idx][0] > guest[j][0]){
						idx = j;
					}else if(guest[idx][0] == guest[j][0]){
						if(guest[idx][1] > guest[j][1]){
							idx = j;
						}
					}
				}
			}

			int go = dist[taxi[0]][taxi[1]][guest[idx][0]][guest[idx][1]];
			int back = dist[guest[idx][0]][guest[idx][1]][destination[idx][0]][destination[idx][1]];

			if(go == -1 || back == -1 || K-go-back < 0){
				System.out.println(-1);
				return;
			}

			K -= go - back;
			taxi[0] = destination[idx][0];
			taxi[1] = destination[idx][1];
			guest[idx][2] = 1;
		}

		System.out.println(K);

	}

	static void bfs(){
		dist = new int[N][N][N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				for(int k=0; k<N; k++){
					Arrays.fill(dist[i][j][k], -1);
				}
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(isWall[i][j]) continue;

				Queue<int[]> q = new ArrayDeque<>();
				q.add(new int[]{i, j});
				dist[i][j][i][j] = 0;

				while(!q.isEmpty()){

					int[] n = q.remove();

					for(int k=0; k<4; k++){
						int a = n[0] + dr[k];
						int b = n[1] + dc[k];
						if(a<0 || a>N-1 || b<0 || b>N-1) continue;
						if(isWall[a][b]) continue;
						if(dist[i][j][a][b] != -1) continue;
						q.add(new int[]{a, b});
						dist[i][j][a][b] = dist[i][j][n[0]][n[1]] + 1;
					}
				}
			}
		}
	}

	static void print(){
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				System.out.println(i+", "+j);
				for(int x=0; x<N; x++){
					for(int y=0; y<N; y++){
						System.out.print(dist[i][j][x][y]+" ");
					}System.out.println();
				}System.out.println();
			}
		}
	}

}
