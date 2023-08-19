import java.io.*;
import java.util.*;

public class Main {

	static int N, M, p, q, n, dr[] = { -1, 0, 1, 0 }, dc[] = { 0, 1, 0, -1 }, map[][], ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		p = Integer.parseInt(st.nextToken());
		q = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		while (true) {
			
			if (map[p][q]==0) {
				map[p][q] = -1;
				ans++;
			}
			
			boolean state = false;
			for (int i = 0; i < 4; i++) {
				int a = p + dr[i];
				int b = q + dc[i];
				if(a<0||a>N-1||b<0||b>M-1) continue;
				if(map[a][b]==0) {
					state = true;
					break;
				}
			}
			if (state) {
				n = (n+3)%4;
				if (map[p+dr[n]][q+dc[n]]==0) {
					p += dr[n];
					q += dc[n];
					continue;
				}
			}else {
				if (map[p-dr[n]][q-dc[n]]==1) {
					break;
				}else {
					p -= dr[n];
					q -= dc[n];
					continue;
				}
			}
			
		}
		bw.write(ans+"\n");
		bw.close();

	}

}