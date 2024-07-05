import java.io.*;
import java.util.*;

public class Main {

	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int N, M, ans;
	static char map[][];
	static boolean visitS[][], visitL[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] tmp = br.readLine().split(" ");
		N = Integer.parseInt(tmp[0]);
		M = Integer.parseInt(tmp[1]);
		map = new char[N][];
		for(int i=0; i<N; i++){
			map[i] = br.readLine().toCharArray();
		}

		visitS = new boolean[N][M];
		visitL = new boolean[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				if(!visitS[i][j]){
					visitL[i][j] = true;
					dfs(i, j);
					visitL[i][j] = false;
				}
			}
		}

		System.out.println(ans);

	}

	static void dfs(int x, int y){

		if(visitS[x][y]) return;
		visitS[x][y] = true;

		int d = convert(map[x][y]);
		int a = x + dr[d];
		int b = y + dc[d];
		if(visitL[a][b]){
			ans++;
			return;
		}
		visitL[a][b] = true;
		dfs(a, b);
		visitL[a][b] = false;

	}

	static int convert(char c){
		switch(c){
			case 'U':
				return 0;
			case 'D':
				return 2;
			case 'L':
				return 3;
			default:
				return 1;
		}
	}

}
