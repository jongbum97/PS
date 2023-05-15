import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] score = new int[N];
			for(int i=0; i<N*M; i++){
				if(sc.nextInt()==1){
					score[i/M]++;
				}
			}
			
			int max = 0;
			int count = 0;
			for(int i=0; i<N; i++){
				if(score[i]>max){
					max = score[i];
					count = 1;
				}else if (score[i]==max) {
					count++;
				}
			}
			
			
			
			System.out.println("#"+tc+" "+count+" "+max);
			
			
			
			
		}
	}
	

}
