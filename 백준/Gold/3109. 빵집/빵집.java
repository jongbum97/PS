import java.io.*;
import java.util.*;

public class Main {

	static int R, C, dr[]={-1, 0, 1}, dc[]={1, 1, 1}, ans;
	static boolean map[][], state, flag;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		char[][] c = new char[R][];
		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			c[i] = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(c[i][j]=='x') map[i][j] = true;
			}
		}
		
		for (int i = 0; i < R; i++) {
			if(flag) break;
			for (int j = 0; j < R; j++) {
			}
			state = false;
			install(i, 0);
		}
		
		bw.write(ans+"\n");
		
		bw.close();
		
	}
	
	
	static void install(int x, int y) {
		map[x][y] = true;
		if(state||flag) return;
		if(y==C-1) {
			ans++;
			state = true;
			return;
		}
		
		for (int i = 0; i < 3; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0||a>R-1||b<0||b>C-1) continue;
			if(map[a][b]) continue;
			install(a, b);
			if(state||flag) return;
			if (b==C-1) {
				flag = true;
				return;
			}
		}

	}
	
	
	
}