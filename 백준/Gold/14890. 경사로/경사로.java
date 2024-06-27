import java.io.*;
import java.util.*;

public class Main {

	static int N, L, map[][], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i=0; i<N; i++){
			check(i, 0, 0, 1);
			check(0, i, 1, 0);
		}

		System.out.println(ans);

	}

	private static void check(int r, int c, int dr, int dc) {

		int t = -1, cnt = 1;
		while (++t < N-1){
			int x1 = r + dr*t;
			int y1 = c + dc*t;
			int x2 = r + dr*(t+1);
			int y2 = c + dc*(t+1);

			if(map[x1][y1] == map[x2][y2]){
				cnt++;
			}else if(map[x1][y1] - map[x2][y2] == 1){
				if(cnt < 0) return;
				cnt = 1-L;
			} else if (map[x1][y1] - map[x2][y2] == -1) {
				if(cnt < L) return;
				cnt = 1;
			}else {
				return;
			}
		}
		if(cnt>=0)
			ans++;
	}
}
