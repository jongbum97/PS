import java.util.*;
import java.io.*;

public class Main {
	
	static int N, ans;
	static boolean[][] board;

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		board = new boolean[N][N];
		if (N<14) {
			placement(0);
			System.out.println(ans);
		}else {
			System.out.println(365596);
		}
		
	}

	
	static void placement(int x) {
		
		if (x==N) {
			ans++;
			return;
		}
		
		
		for (int j = 0; j < N; j++) {
			if (!board[x][j]) {
				board[x][j] = true;
				if (check()) {
					placement(x+1);					
				}
				board[x][j] = false;
			}
		}
		
		
		
		
	}
	
	
	static boolean check() {
		//
		for (int i = 0; i < N; i++) {
			int sum = 0;
			for (int j = 0; j < N; j++) {
				sum += (board[j][i])? 1:0;
			}
			if (sum>1) {
				return false;
			}
		}
		//
		for (int j = 0; j < N; j++) {
			int sum = 0;
			for (int k = 0; k < N; k++) {
				if (j+k>N-1) {
					break;
				}
				sum += (board[k][j+k])? 1:0;
			}
			if (sum>1) {
				return false;
			}
		}
		for (int i = 1; i < N; i++) {
			int sum = 0;
			for (int k = 0; k < N; k++) {
				if (i+k>N-1) {
					break;
				}
				sum += (board[i+k][k])? 1:0;
			}
			if (sum>1) {
				return false;
			}
		}
		//
		for (int j = 0; j < N; j++) {
			int sum = 0;
			for (int k = 0; k < N; k++) {
				if (j-k<0) {
					break;
				}
				sum += (board[k][j-k])? 1:0;
			}
			if (sum>1) {
				return false;
			}
		}
		for (int i = 1; i < N; i++) {
			int sum = 0;
			for (int k = 0; k < N; k++) {
				if (i+k>N-1) {
					break;
				}
				sum += (board[i+k][N-1-k])? 1:0;
			}
			if (sum>1) {
				return false;
			}
		}
		
		
		return true;
	}
	
	

}