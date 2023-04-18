import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] painting = new int[101][101];
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] mosaic = new int [N][4];
		for(int i=0; i<N; i++){
			mosaic[i][0] = sc.nextInt();
			mosaic[i][1] = sc.nextInt();
			mosaic[i][2] = sc.nextInt();
			mosaic[i][3] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++){
			for(int j=mosaic[i][0]; j<=mosaic[i][2]; j++){
				for(int k=mosaic[i][1]; k<=mosaic[i][3]; k++){
					painting[j][k]++;
				}
			}
		}
		
		int ans = 0;
		for(int i=1; i<=100; i++){
			for(int j=1; j<=100 ; j++){
				if(painting[i][j]>M){
					ans++;
				}
			}
		}
		
		System.out.println(ans);
		
		
		
	}
}