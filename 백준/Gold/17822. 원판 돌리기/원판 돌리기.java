import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, T, plate[][], key[], dr[]= {-1,0,1,0}, dc[]= {0,1,0,-1}, ans;
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		plate = new int[N][M];
		key = new int[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				plate[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			for (int j = 0; j < N; j++) {
				if((j+1)%x==0) {
					int dd = (d==0)? -1:1;
					key[j] += (dd*k+M)%M;
				}
			}
			seek();
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				ans += plate[i][j];
			}
		}
		
		bw.write(ans+"\n");
		
		bw.close();
	

	
	}

	static void seek() {
		visit = new boolean[N][M];
		boolean bb = false;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visit[i][j]&&plate[i][j]!=0) {
					if (BFS(i,j)) {
						bb = true;
					}
				}
			}
		}
		if (!bb) {
			double sum = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (plate[i][j]!=0) {
						sum += plate[i][j];
						cnt++;
					}
				}
			}
			sum /= cnt;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(plate[i][j]==0) continue;
					if (plate[i][j]>sum) {
						plate[i][j]--;
					}else if(plate[i][j]<sum){
						plate[i][j]++;
					}
				}
			}
		}
		
	}

	static boolean BFS(int x, int y) {
		boolean bb = false;
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, y});
		visit[x][y] = true;
		
		while (!q.isEmpty()) {
			
			int[] n = q.remove();
			
			for (int i = 0; i < 4; i++) {
				int a = n[0] + dr[i];
				int b = n[1] + dc[i];
				if(a<0||a>N-1) continue;
				b += key[a]-key[n[0]]+M*100;
				b %= M;
				if(plate[a][b]==0) continue;
				if(visit[a][b]) continue;
				if(plate[x][y]==plate[a][b]) {
					bb = true;
					plate[a][b] = 0;
					visit[a][b] = true;
					q.add(new int[] {a,b});
				}
			}
			
		}
		
		if(bb) plate[x][y] = 0;
		return bb;
	}

	
}