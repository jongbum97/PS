import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] students = new int[N];
			for(int i=0; i<K; i++){
				students[sc.nextInt()-1]++;
			}
			
			System.out.print("#"+tc);
			for(int i=0; i<N; i++){
				if(students[i]==0){
					System.out.print(" "+(i+1));
				}
			}
			System.out.println();
			
			
		}

	}
}
