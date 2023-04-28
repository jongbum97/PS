import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] clas = {N, N, N, N, N, N, N}; 
			int[] classes = new int[7];
			for(int i=0; i<7; i++){
				classes[i] = sc.nextInt();
			}
			
			int[] ans = new int[7];
			for(int i=0; i<7; i++){
				int k = i;
				while(clas[i]>0){
					ans[i]++;
					if(classes[(k++)%7]==1){
						clas[i]--;
					}
				}
				
			}
			
			Arrays.sort(ans);
			
			System.out.println("#"+tc+" "+ans[0]);
		}
	}
}
