import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			char[][] board = new char[8][8];
			for(int i=0; i<8; i++){
				board[i] = sc.next().toCharArray();
			}
			int[] check = new int[8];
			
			String ans = "yes";
			int count = 0;
			for(int i=0; i<8; i++){
				if(ans.equals("no")){
					break;
				}
				for(int j=0; j<8; j++){
					if(board[i][j]=='O'){
						if(check[j]==0){
							check[j]=1;
							count++;
						}else {
							ans="no";
							break;
						}
					}
				}
				if(count!=i+1){
					ans="no";
					break;
				}
			}
			if(count!=8){
				ans="no";
			}
			System.out.println("#"+tc+" "+ans);
			
		}

	}
}
