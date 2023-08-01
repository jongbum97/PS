import java.util.*;
import java.io.*;

public class Main {

	static int[][] board, max, min;
	static int N;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][3];
		max = new int[N][3];
		min = new int[N][3];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < 3; i++) {
			max[0][i] = min[0][i] = board[0][i];
		}
		
		for (int i = 1; i < N; i++) {
			max[i][0] = Math.max(max[i-1][0], max[i-1][1]) + board[i][0];
			max[i][1] = Math.max(Math.max(max[i-1][0], max[i-1][1]), max[i-1][2]) + board[i][1];
			max[i][2] = Math.max(max[i-1][1], max[i-1][2]) + board[i][2];
		}
		Arrays.sort(max[N-1]);
		
		for (int i = 1; i < N; i++) {
			min[i][0] = Math.min(min[i-1][0], min[i-1][1]) + board[i][0];
			min[i][1] = Math.min(Math.min(min[i-1][0], min[i-1][1]), min[i-1][2]) + board[i][1];
			min[i][2] = Math.min(min[i-1][1], min[i-1][2]) + board[i][2];
		}
		Arrays.sort(min[N-1]);

		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(max[N-1][2]+" "+min[N-1][0]+"\n");
		bw.close();
	}
	

}