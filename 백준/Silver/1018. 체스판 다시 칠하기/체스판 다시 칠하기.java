import java.util.*;

public class Main {
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		String[][] board = new String[N][M];
		for(int i=0; i<N; i++){
			board[i] = sc.next().split("");
		}
		int count = 0;
		int[] ans = new int[(N-7)*(M-7)];
		for(int i=0; i<=N-8; i++){
			for(int j=0; j<=M-8 ; j++){
				int W = 0;
				int B = 0;
				for(int k=i; k<i+8; k++){
					for(int l=j; l<j+8; l++){
						if((k+l)%2==0){
							if(board[k][l].equals("W")){
								W++;
							}
						}else {
							if(board[k][l].equals("B")){
								B++;
							}
						}
					}
				}
				ans[count++] = (64-(W+B)<W+B)? 64-(W+B) : W+B;
			}
		}
		Arrays.sort(ans);
		System.out.println(ans[0]);
		
	}
}
