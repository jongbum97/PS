import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			double[] darts = new double[N];
			for(int i=0; i<N; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				darts[i] = Math.sqrt(a*a+b*b);
			}
			int[] circle = {20,40,60,80,100,120,140,160,180,200};
			int ans = 0;
			for(int i=0; i<N; i++){
				for(int j=0; j<10 ; j++){
					if(darts[i]>circle[j]){
						continue;
					}else{
						ans += 10-j;
						break;
					} 
				}
			}

			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
