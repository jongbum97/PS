import java.io.*;
import java.util.*;

public class Main {

	static int L, W, dis[][], ans, dr[]={-1, 0, 1, 0}, dc[]={0, 1, 0, -1};
	static char[][] map;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] lw = br.readLine().split(" ");
		W = Integer.parseInt(lw[0]);
		L = Integer.parseInt(lw[1]);
		map = new char[W][];
		for(int i=0; i<W; i++){
			map[i] = br.readLine().toCharArray();
		}

		for (int i=0; i<W; i++){
			for (int j=0; j<L; j++){
				if(map[i][j] == 'L')
					bfs(i, j);
			}
		}

		System.out.println(ans-1);

	}

	private static void bfs(int x, int y) {
		dis = new int[W][L];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x, y});
		dis[x][y] = 1;

		while (!q.isEmpty()){

			int[] n = q.remove();

			for (int i=0; i<4; i++){
				int r = n[0] + dr[i];
				int c = n[1] + dc[i];
				if(r<0 || r>=W || c<0 || c>=L) continue;
				if(map[r][c] == 'W' || dis[r][c] != 0) continue;

				q.add(new int[]{r, c});
				dis[r][c] = dis[n[0]][n[1]] + 1;
			}

		}

		for (int i=0; i<W; i++){
			for (int j=0; j<L; j++){
				ans = Math.max(ans, dis[i][j]);
			}
		}

	}


}
