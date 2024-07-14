import java.io.*;
import java.util.*;

public class Main {

	static final int[][] map = {
									{-1, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 0, 0, 0, 0, 0},
									{-1, 13, 16, 19, 25, 30, 35, 40, 0, 0, 0, 0, 0},
									{-1, 22, 24, 25, 30, 35, 40, 0, 0, 0, 0, 0, 0},
									{-1, 28, 27, 26, 25, 30, 35, 40, 0, 0, 0, 0, 0}
								};
	static int dice[], ans;
	static Token[] tokens;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		dice = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<10; i++){
			dice[i] = Integer.parseInt(st.nextToken());
		}
		tokens = new Token[4];
		for(int i=0; i<4; i++){
			tokens[i] = new Token(0, 0);
		}

		play(0, 0);
		System.out.println(ans);

	}

	static void play(int cnt, int sum) {
		ans = Math.max(ans, sum);
		if (cnt == 10) return;

		for (int i = 0; i < 4; i++) {
			Token t = tokens[i];

			int mapIdx = t.mapIdx;
			int position = t.position;
			if (map[t.mapIdx][t.position] == 0) continue;
			int m = map[t.mapIdx][t.position += dice[cnt]];

			if (t.mapIdx == 0) {
				if (m == 10) {
					t.mapIdx = 1;
					t.position = 0;
				} else if (m == 20) {
					t.mapIdx = 2;
					t.position = 0;
				} else if (m == 30) {
					t.mapIdx = 3;
					t.position = 0;
				}
			}
			if(check(i, t.mapIdx, t.position)){
				play(cnt + 1, sum + m);
			}
			t.mapIdx = mapIdx;
			t.position = position;
		}

	}

	static boolean check(int idx, int mapIdx, int position){
		if(map[mapIdx][position] == 0) return true;
		if(mapIdx == 0 && position == 0) return true;
		for(int i=0; i<4; i++){
			if(i == idx) continue;
			Token t = tokens[i];
			if(t.mapIdx == mapIdx && t.position == position)
				return false;
			if(map[t.mapIdx][t.position] == 25 && map[mapIdx][position] == 25)
				return false;
			if(map[t.mapIdx][t.position] == 40 && map[mapIdx][position] == 40)
				return false;
			if(map[t.mapIdx][t.position] == 30 && map[mapIdx][position] == 30)
				return false;
			if(map[t.mapIdx][t.position] == 35 && map[mapIdx][position] == 35)
				return false;
		}
		return true;
	}

	static class Token{
		int mapIdx;
		int position;
		Token(int mapIdx, int position){
			this.mapIdx = mapIdx;
			this.position = position;
		}
		@Override
		public String toString(){
			return mapIdx+": "+position;
		}
	}

}
