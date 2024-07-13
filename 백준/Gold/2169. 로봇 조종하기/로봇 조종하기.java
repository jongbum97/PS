import java.io.*;
import java.util.*;

public class Main {

	static int N, M, map[][], dis[][][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N+2][M+2];
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dis = new int[N+2][M+2][3];
		for(int i=0; i<N+2; i++){
			for(int j=0; j<M+2; j++){
				Arrays.fill(dis[i][j], Integer.MIN_VALUE/10);
			}
			dis[1][1][0] = map[1][1];
		}

		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++){
				dis[i][j+1][2] = Math.max(dis[i][j][0], dis[i][j][2]) + map[i][j+1];
				dis[i][M-j][1] = Math.max(dis[i][M-j+1][0], dis[i][M-j+1][1]) + map[i][M-j];
			}
			for(int j=1; j<=M; j++){
				dis[i+1][j][0] = Math.max(dis[i][j][0], Math.max(dis[i][j][1], dis[i][j][2])) + map[i+1][j];
			}
		}

		System.out.println(Math.max(dis[N][M][0], Math.max(dis[N][M][1], dis[N][M][2])));

	}

}
