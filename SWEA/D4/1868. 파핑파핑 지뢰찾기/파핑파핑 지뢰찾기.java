import java.io.*;
import java.util.*;

public class Solution {
	
	static int N, dr[]= {-1, -1, 0, 1, 1, 1, 0, -1}, dc[] = {0, 1, 1, 1, 0, -1, -1, -1}, ans;
	static char map[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][];
			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			ans = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.' && check(i, j)==0) {
						BFS(i, j);
						ans++;
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]=='.') {
						BFS(i, j);
						ans++;
					}
				}
			}
			
			
			bw.write("#"+tc+" "+ans+"\n");
			
		}
		bw.close();
		
		
	}
	
	static void BFS(int x, int y) {
		
		int count = check(x, y);
		map[x][y] = (char)(count+'0');
		
		if (count==0) {
			for (int i = 0; i < 8; i++) {
				int a = x + dr[i];
				int b = y + dc[i];
				if(a<0||a>N-1||b<0||b>N-1) continue;
				if(map[a][b]=='.') BFS(a,b);
			}
		}
		
	}
	
	static int check(int x, int y) {
		int count = 0;
		for (int i = 0; i < 8; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0||a>N-1||b<0||b>N-1) continue;
			if(map[a][b]=='*') count++;
		}
		return count;
	}

}
