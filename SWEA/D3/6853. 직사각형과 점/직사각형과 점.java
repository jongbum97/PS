import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int N = sc.nextInt();
			int[][] xy = new int[N][2];
			for(int i=0; i<N; i++){
				int k = sc.nextInt();
				if(k<x1 || k>x2){
					xy[i][0] = -1;
				}else if (k==x1 || k==x2) {
					xy[i][0] = 0;
				}else {
					xy[i][0] = 1;
				}
				int n = sc.nextInt();
				if(n<y1 || n>y2){
					xy[i][1] = -1;
				}else if (n==y1 || n==y2) {
					xy[i][1] = 0;
				}else {
					xy[i][1] = 1;
				}
			}
			
			int ans0 = 0;
			int ans1 = 0;
			int ans2 = 0;
			for(int i=0; i<N; i++){
				if((xy[i][0]==0 && xy[i][1]!=-1)||(xy[i][1]==0&&xy[i][0]!=-1)){
					ans1++;
				}else if (xy[i][0]==1 && xy[i][1]==1) {
					ans2++;
				}
			}
			ans0 = N-ans1-ans2;
			
			System.out.println("#"+tc+" "+ans2+" "+ans1+" "+ans0);
			
			
			
			
		}
	}
	

}
