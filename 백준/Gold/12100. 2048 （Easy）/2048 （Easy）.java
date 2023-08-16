import java.io.*;
import java.util.*;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		int[][] board = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		game(board, 0);
		bw.write(ans+"\n");
		bw.close();
	}
	
	static void game(int[][] B, int n) {
	
		if(n==5) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					ans = Math.max(ans, B[i][j]);
				}
			}
			return;
		}
		
		game(moveR(B),n+1);
		game(moveL(B),n+1);
		game(moveU(B),n+1);
		game(moveD(B),n+1);
		
	}
	
	
	static int[][] moveR(int[][] b) {
		int[][] bb = new int[N][];
		for (int i = 0; i < N; i++) {
			bb[i] = b[i].clone();
		}
		List<Integer> list = new ArrayList<>();
		int a;
		for (int j = 0; j < N; j++) {
			list.clear();
			a = N-1;
			for (int i = N-1; i >= 0; i--) {
				if (bb[j][i] != 0) {
					list.add(b[j][i]);
					bb[j][i] = 0;
				}
			}
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).equals(list.get(i + 1))) {
					list.add(i, 2 * list.get(i));
					list.remove(i + 1);
					list.remove(i + 1);
				}
			}
			while (!list.isEmpty()) {
				bb[j][a--] = list.remove(0);
			}
		}
		return bb;
	}
	static int[][] moveL(int[][] b) {
		int[][] bb = new int[N][];
		for (int i = 0; i < N; i++) {
			bb[i] = b[i].clone();
		}
		List<Integer> list = new ArrayList<>();
		int a;
		for (int j = 0; j < N; j++) {
			list.clear();
			a = 0;
			for (int i = 0; i < N; i++) {
				if (bb[j][i] != 0) {
					list.add(b[j][i]);
					bb[j][i] = 0;
				}
			}
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).equals(list.get(i + 1))) {
					list.add(i, 2 * list.get(i));
					list.remove(i + 1);
					list.remove(i + 1);
				}
			}
			while (!list.isEmpty()) {
				bb[j][a++] = list.remove(0);
			}
		}
		return bb;
	}
	static int[][] moveU(int[][] b) {
		int[][] bb = new int[N][];
		for (int i = 0; i < N; i++) {
			bb[i] = b[i].clone();
		}
		List<Integer> list = new ArrayList<>();
		int a;
		for (int j = 0; j < N; j++) {
			list.clear();
			a = 0;
			for (int i = 0; i < N; i++) {
				if (bb[i][j] != 0) {
					list.add(b[i][j]);
					bb[i][j] = 0;
				}
			}
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).equals(list.get(i + 1))) {
					list.add(i, 2 * list.get(i));
					list.remove(i + 1);
					list.remove(i + 1);
				}
			}
			while (!list.isEmpty()) {
				bb[a++][j] = list.remove(0);
			}
		}
		return bb;
	}
	static int[][] moveD(int[][] b) {
		int[][] bb = new int[N][];
		for (int i = 0; i < N; i++) {
			bb[i] = b[i].clone();
		}
		List<Integer> list = new ArrayList<>();
		int a;
		for (int j = 0; j < N; j++) {
			list.clear();
			a = N-1;
			for (int i = N-1; i >= 0; i--) {
				if (bb[i][j] != 0) {
					list.add(b[i][j]);
					bb[i][j] = 0;
				}
			}
			for (int i = 0; i < list.size()-1; i++) {
				if (list.get(i).equals(list.get(i + 1))) {
					list.add(i, 2 * list.get(i));
					list.remove(i + 1);
					list.remove(i + 1);
				}
			}
			while (!list.isEmpty()) {
				bb[a--][j] = list.remove(0);
			}
		}
		return bb;
	}
	
}