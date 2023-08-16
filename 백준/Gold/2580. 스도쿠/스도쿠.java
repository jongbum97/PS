import java.io.*;
import java.util.*;

public class Main {

	static int ans, board[][];
	static boolean state;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		DFS(0,0);
		bw.write(sb.toString());
		bw.close();
	}
	
	
	static void DFS(int x, int y) {
		
		state = true;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(board[i][j]==0) {
					state = false;
				}
			}
		}
		if(state) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(board[i][j]+" ");
				}sb.append("\n");
			}
			return;
		}
		
		for (int i = x; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(i==x&&j<y) continue;
				if (board[i][j]==0) {
					for (int k = 1; k <= 9; k++) {
						if (check(i, j, k)&&!state) {
							board[i][j] = k;
							DFS(i, j);
						}
					}
					board[i][j] = 0;
					return;
				}
			}
		}
	}
	
	static boolean check(int x, int y, int n) {
		return (checkS(x, y, n)&&checkR(x, y, n)&&checkC(x, y, n));
	}
	
	static boolean checkS(int x, int y, int n) {
		
		int a = (x<3)? 0:(x<6)? 3:6;
		int b = (y<3)? 0:(y<6)? 3:6;
		
		for (int i = a; i < a+3; i++) {
			for (int j = b; j < b+3; j++) {
				if(board[i][j]==n) return false;
			}
		}
		return true;
	}
	static boolean checkR(int x, int y, int n) {
		
		for (int i = 0; i < 9; i++) {
			if(board[x][i]==n) return false;
		}
		return true;
	}
	static boolean checkC(int x, int y, int n) {
		
		for (int i = 0; i < 9; i++) {
			if(board[i][y]==n) return false;
		}
		return true;
	}
	
}