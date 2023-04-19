import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] score = new int[N][3];
		for(int i=0; i<N; i++){
			score[i][0] = sc.nextInt();
			score[i][1] = sc.nextInt();
			score[i][2] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			for(int j=i+1; j<N ; j++){
				if(score[i][2]<score[j][2]){
					int[] tmp;
					tmp = score[i];
					score[i] = score[j];
					score[j] = tmp;
				}
			}
		}
	
		
		System.out.println(score[0][0]+" "+score[0][1]);
		System.out.println(score[1][0]+" "+score[1][1]);
		
		if(score[0][0]==score[1][0]){
			for(int i=2; i<N; i++){
				if(score[i][0]!=score[0][0]){
					System.out.println(score[i][0]+" "+score[i][1]);
					break;
				}
			}
		}else {
			System.out.println(score[2][0]+" "+score[2][1]);
		}
	}
}