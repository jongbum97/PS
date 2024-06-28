import java.io.*;
import java.util.*;

public class Main {

	static final int[] dr = {0, -1, 0, 1}, dc = {1, 0, -1, 0};
	static int N, x, y, d ,g, map[][], ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		map = new int[101][101];
		ans = 0;
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			create();
		}

		for(int i=0; i<100; i++){
			for(int j=0; j<100; j++){
				if(map[i][j]*map[i+1][j]*map[i][j+1]*map[i+1][j+1]!=0)
					ans++;
			}
		}

		System.out.println(ans);

	}

	static void create() {

		int [][] data = dragon(new int[][]{{x, y}, {x+dr[d], y+dc[d]}}, 1);
		for (int[] spot : data){
			map[spot[0]][spot[1]]++;
		}
	}

	static int[][] dragon(int[][] board, int level){
		if(level == g+1) return board;

		int cnt = (1<<(level-1))+1;
		int[][] data = new int[2*cnt-1][];
		for (int i=0; i<cnt; i++){
			data[i] = board[i].clone();
		}
		for (int i=cnt; i<2*cnt-1; i++){
			data[i] = spin(data[2*cnt-i-2], data[cnt-1]);
		}

		return dragon(data, level+1);

	}

	static int[] spin(int[] point, int[] center){
		int dy =  point[0] - center[0];
		int dx =  point[1] - center[1];

		return new int[]{center[0] + dx, center[1] - dy};
	}


}
