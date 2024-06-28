import java.io.*;
import java.util.*;

public class Main {

	static final int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int ans, cnt;
	static char map[][];
	static boolean visit[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new char[12][];
		for(int i=0; i<12; i++){
			map[i] = br.readLine().toCharArray();
		}

		while(boom()){
			down();
			ans++;
		}

		System.out.println(ans);

	}

	static boolean boom(){
		boolean flag = false;

		for(int i=0; i<12; i++){
			for(int j=0; j<6; j++){
				if(map[i][j] == '.') continue;
				visit = new boolean[12][6];
				cnt = 0;
				dfs(i, j, map[i][j]);
				if(cnt >= 4){
					delete();
					flag = true;
				}
			}
		}

		return flag;
	}

	static void dfs(int x, int y, char color){
		visit[x][y] = true;
		cnt++;

		for(int i=0; i<4; i++){
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0 || a>11 || b<0 || b>5) continue;
			if(map[a][b] != color || visit[a][b]) continue;
			dfs(a, b, color);
		}
    }

	static void delete(){
		for(int i=0; i<12; i++){
			for(int j=0; j<6; j++){
				if(visit[i][j]) {
					map[i][j] = '.';
				}
			}
		}
	}

	static void down(){
		for(int j=0; j<6; j++){
			Stack<Character> stack = new Stack<>();
			for(int i=0; i<12; i++){
				if(map[i][j] != '.'){
					stack.push(map[i][j]);
				}
			}
			for(int i=11; i>=0; i--){
				if(!stack.isEmpty()){
					map[i][j] = stack.pop();
				}else{
					map[i][j] = '.';
				}
			}
		}
	}

}
