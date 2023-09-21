import java.io.*;
import java.util.*;

public class Main {
	
	static int ans, cntt, blank;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[][] board = new char[10][];
		for (int i = 0; i < 10; i++) {
			board[i] = br.readLine().replace(" ", "").toCharArray();
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if(board[i][j]=='1') blank++;
			}
		}
		
		cntt = 26;
		five(board, 0, 0, 0);
		
		System.out.println((cntt==26)? -1:cntt);
		
	}

	static void five(char[][] board, int a, int b, int cnt) {
		if(ans>=cntt) return;
		for (int i = 0; i <= 5; i++) {
			if(cnt>4) break;
			outer : for (int j = 0; j <= 5; j++) {
				if(i<a||(i==a&&j<b)) continue;
				for (int x = i; x < i+5; x++) {
					for (int y = j; y < j+5; y++) {
						if(board[x][y]=='0') continue outer;
					}
				}
				char[][] tmp = copy(board);
				for (int x = i; x < i+5; x++) {
					for (int y = j; y < j+5; y++) {
						tmp[x][y] = '0';
					}
				}
				blank -= 25;
				ans++;
				five(tmp, i, j, cnt+1);
				blank += 25;
				ans--;
			}
		}
		four(board, 0, 0, 0);
	}

	static void four(char[][] board, int a, int b, int cnt) {
		if(ans>=cntt) return;
		for (int i = 0; i <= 6; i++) {
			if(cnt>4) break;
			outer : for (int j = 0; j <= 6; j++) {
				if(i<a||(i==a&&j<b)) continue;
				for (int x = i; x < i+4; x++) {
					for (int y = j; y < j+4; y++) {
						if(board[x][y]=='0') continue outer;
					}
				}
				char[][] tmp = copy(board);
				for (int x = i; x < i+4; x++) {
					for (int y = j; y < j+4; y++) {
						tmp[x][y] = '0';
					}
				}
				ans++;
				blank -= 16;
				four(tmp, i, j, cnt+1);
				blank += 16;
				ans--;
			}
		}
		if(blank>70) return;
		three(board, 0, 0, 0);
	}
	
	static void three(char[][] board, int a, int b, int cnt) {
		if(ans>=cntt) return;
		for (int i = 0; i <= 7; i++) {
			if(cnt>4) break;
			outer : for (int j = 0; j <= 7; j++) {
				if(i<a||(i==a&&j<b)) continue;
				for (int x = i; x < i+3; x++) {
					for (int y = j; y < j+3; y++) {
						if(board[x][y]=='0') continue outer;
					}
				}
				char[][] tmp = copy(board);
				for (int x = i; x < i+3; x++) {
					for (int y = j; y < j+3; y++) {
						tmp[x][y] = '0';
					}
				}
				ans++;
				blank -= 9;
				three(tmp, i, j, cnt+1);
				blank += 9;
				ans--;
			}
		}
		if(blank>25) return;
		two(board, 0, 0, 0);
	}
	
	static void two(char[][] board, int a, int b, int cnt) {
		if(ans>=cntt) return;
		for (int i = 0; i <= 8; i++) {
			if(cnt>4) break;
			outer : for (int j = 0; j <= 8; j++) {
				if(i<a||(i==a&&j<b)) continue;
				for (int x = i; x < i+2; x++) {
					for (int y = j; y < j+2; y++) {
						if(board[x][y]=='0') continue outer;
					}
				}
				char[][] tmp = copy(board);
				for (int x = i; x < i+2; x++) {
					for (int y = j; y < j+2; y++) {
						tmp[x][y] = '0';
					}
				}
				ans++;
				blank -= 4;
				two(tmp, i, j, cnt+1);
				blank += 4;
				ans--;
			}
		}
		if(blank>5) return;
		one(board, 0, 0, 0);
	}
	
	static void one(char[][] board, int a, int b, int cnt) {
		if(ans>=cntt) return;
		for (int i = 0; i <= 9; i++) {
			if(cnt>4) break;
			outer : for (int j = 0; j <= 9; j++) {
				if(i<a||(i==a&&j<b)) continue;
				for (int x = i; x < i+1; x++) {
					for (int y = j; y < j+1; y++) {
						if(board[x][y]=='0') continue outer;
					}
				}
				char[][] tmp = copy(board);
				for (int x = i; x < i+1; x++) {
					for (int y = j; y < j+1; y++) {
						tmp[x][y] = '0';
					}
				}
				ans++;
				blank -= 1;
				one(tmp, i, j, cnt+1);
				blank += 1;
				ans--;
			}
		}
		if(blank!=0) return;
		cntt = Math.min(cntt, ans);
	}

	static char[][] copy(char[][] board){
		char[][] tmp = new char[10][];
		for (int i = 0; i < 10; i++) {
			tmp[i] = board[i].clone();
		}
		return tmp;
	}
}

