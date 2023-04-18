import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] arr1 = new int[N][M];
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				arr1[i][j] = sc.nextInt();
			}
		}
		M = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr2 = new int[M][K];
		for(int i=0; i<M; i++){
			for(int j=0; j<K; j++){
				arr2[i][j] = sc.nextInt();
			}
		}
		
		for(int i=0; i<N; i++){
			for(int j=0; j<K ; j++){
				int x = 0;
				for(int m=0; m<M; m++){
					x += arr1[i][m]*arr2[m][j];
				}
				System.out.print(x+" ");
			}
			System.out.println();
		}
		
		
		
		
		
		
	}
}