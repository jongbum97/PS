import java.util.*;

public class Main {

	static int[][] board = new int[5][5];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int i=0; i<5; i++){
			for(int j=0; j<5 ; j++){
				board[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<25; i++){
			erase(sc.nextInt());
			if(check()>=3){
				System.out.println(i+1);
				break;
			}
		}
		
		
	}
	
	static void erase(int n) {
		outer: for(int i=0; i<5; i++){
			for(int j=0; j<5 ; j++){
				if(board[i][j]==n){
					board[i][j]=0;
					break outer;
				}
			}
		}
	}
	
	
	static int check() {
		
		return xCheck()+yCheck()+crossCheck();
	}

	static int xCheck() {
		int n = 0;
		for(int i=0; i<5; i++) {
			int idx = 0;
			for(int j=0; j<5; j++) {
				if(board[i][j]==0) {
					idx++;
				}else {
					break;
				}
			}
			if(idx==5){
				n++;
			}
		}
		return n;
	}

	static int yCheck() {
		int n = 0;
		for(int i=0; i<5; i++) {
			int idx = 0;
			for(int j=0; j<5; j++) {
				if(board[j][i]==0) {
					idx++;
				}else {
					break;
				}
			}
			if(idx==5){
				n++;
			}
		}
		return n;
	}

	static int crossCheck() {
		int n = 0;
		int idx = 0;
		for(int i=0; i<5; i++) {
			if(board[i][i]==0){
				idx++;
			}
		}
		if(idx==5){
			n++;
		}
		idx = 0;
		for(int i=0; i<5; i++) {
			if(board[i][4-i]==0){
				idx++;
			}
		}
		if(idx==5){
			n++;
		}
		
		return n;
	}
}