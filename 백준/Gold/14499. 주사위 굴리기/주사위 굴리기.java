import java.io.*;
import java.util.*;

public class Main {

	static int N, M, x, y, K, map[][], dice[];
	static StringBuilder sb;


	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		N =Integer.parseInt(st.nextToken());
		M =Integer.parseInt(st.nextToken());
		x =Integer.parseInt(st.nextToken());
		y =Integer.parseInt(st.nextToken());
		K =Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dice = new int[6];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<K; i++){
			move(Integer.parseInt(st.nextToken()));
		}

		System.out.println(sb);
	}

	static void move(int n) {
		if(n == 1){
			if(y+1 > M-1) return;
			y++;
			dice = new int[]{dice[4], dice[1], dice[2], dice[0], dice[5], dice[3]};
		}
		else if(n == 2){
			if(y-1 < 0) return;
			y--;
			dice = new int[]{dice[3], dice[1], dice[2], dice[5], dice[0], dice[4]};
		}
		else if(n == 3){
			if(x-1 < 0) return;
			x--;
			dice = new int[]{dice[1], dice[5], dice[0], dice[3], dice[4], dice[2]};
		}
		else if(n == 4){
			if(x+1 > N-1) return;
			x++;
			dice = new int[]{dice[2], dice[0], dice[5], dice[3], dice[4], dice[1]};
		}

		if(map[x][y] == 0){
			map[x][y] = dice[0];
		}else{
			dice[0] = map[x][y];
			map[x][y] = 0;
		}
		sb.append(dice[5]).append("\n");
	}


}
