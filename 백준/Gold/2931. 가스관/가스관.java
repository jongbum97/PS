import java.io.*;
import java.util.*;

public class Main {

	static int R, C, dr[]={-1,0,1,0}, dc[]={0,1,0,-1}, vector[][]={{0,2},{1,3},{1,2},{0,1},{0,3},{2,3}};
	static char map[][], pipe[] = {'|', '-', '1', '2', '3', '4'};
	static boolean state;
	static List<Integer> list;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		list = new ArrayList<>();
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().toCharArray();
		}

		// 맵에 M이나 Z가 있으면 탐색을 시작한다. 경로 사이에 빈칸을 찾는것이 목적이다
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == '.') {
					if (!state) {
						check(i, j);
					}
				}
			}
		}

		bw.close();

	}


	static void check(int x, int y) throws Exception {
		
		for (int i = 0; i < 4; i++) {
			int a = x + dr[i];
			int b = y + dc[i];
			if(a<0||a>R-1||b<0||b>C-1) continue;
			if (map[a][b]=='.') continue;
			if(map[a][b]=='+') {
				list.add(i);
				continue;
			}
			for (int j = 0; j < 6; j++) {
				if(map[a][b]==pipe[j]) {
					if(((i+2)%4)==vector[j][0]||((i+2)%4)==vector[j][1]) {
						list.add(i);
						state = true;
					}
					break;
				}
			}
		}
		if (state) {
			bw.write((x+1)+" ");
			bw.write((y+1)+" ");
			if (list.size() == 4) {
				bw.write("+\n");
			}else {
				for (int i = 0; i < 6; i++) {
					if (list.get(0)==vector[i][0] && list.get(1)==vector[i][1]) {
						bw.write(pipe[i]+"\n");
						break;
					}
				}
			}
			state = true;
		}
	}

}
