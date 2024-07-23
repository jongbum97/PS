import java.io.*;
import java.util.*;

public class Main {

	static int N, M, map[][], ans;
	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while(search()){
			down();
			turn();
			down();
		}

		System.out.println(ans);

	}

	static void turn(){
		int[][] tmp = new int[N][];
		for(int i=0; i<N; i++){
			tmp[i] = map[i].clone();
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				map[i][j] = tmp[j][N-1-i];
			}
		}
	}

	static void down(){
		for(int j=0; j<N; j++){
			for(int i=N-1; i>0; i--){
				if(map[i][j] == -2) {
					int a = i-1;
					while(a >= 0 && map[a][j] != -1){
						if(map[a][j] == -2) a--;
						else {
							map[i][j] = map[a][j];
							map[a][j] = -2;
							break;
						}
					}
				}
			}
		}
	}

	static boolean search(){
		int max = -1;
		int maxRainbow = -1;
		int[] maxIdx = new int[2];
		boolean[][] visit = new boolean[N][N];

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				int t = map[i][j];
				int cnt = 0;
				int rainbow = 0;
				if(t <= 0 || visit[i][j]) continue;

				Queue<int[]> q = new ArrayDeque<>();
				q.add(new int[]{i, j});
				visit[i][j] = true;

				while(!q.isEmpty()){

					int[] n = q.remove();
					if(map[n[0]][n[1]] == 0) rainbow++;
					cnt ++;

					for(int k=0; k<4; k++){
						int a = n[0] + dr[k];
						int b = n[1] + dc[k];
						if(a<0 || a>N-1 || b<0 || b>N-1 || visit[a][b]) continue;
						if(map[a][b] == 0 || map[a][b] == t){
							q.add(new int[]{a, b});
							visit[a][b] = true;
						}
					}

				}
				for(int c=0; c<N; c++){
					for(int d=0; d<N; d++){
						if(map[c][d] == 0)
							visit[c][d] = false;
					}
				}

				if(cnt>max && cnt>1){
					max = cnt;
					maxRainbow = rainbow;
					maxIdx[0] = i;
					maxIdx[1] = j;
				}else if(cnt == max){
					if(maxRainbow <= rainbow){
						maxRainbow = rainbow;
						maxIdx[0] = i;
						maxIdx[1] = j;
					}
				}
			}
		}

		if(max != -1){
			int t = map[maxIdx[0]][maxIdx[1]];
			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[]{maxIdx[0], maxIdx[1]});
			map[maxIdx[0]][maxIdx[1]] = -2;

			while(!q.isEmpty()){

				int[] n = q.remove();

				for(int k=0; k<4; k++){
					int a = n[0] + dr[k];
					int b = n[1] + dc[k];
					if(a<0 || a>N-1 || b<0 || b>N-1) continue;
					if(map[a][b] == 0 || map[a][b] == t){
						q.add(new int[]{a, b});
						map[a][b] = -2;
					}
				}
			}
			ans += max * max;
			return true;
		}else{
			return false;
		}

	}


}
