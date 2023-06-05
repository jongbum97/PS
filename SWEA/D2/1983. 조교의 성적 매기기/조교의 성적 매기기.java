import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			double[] st = new double[N];
			double[] st2 = new double[N];
			for(int i=0; i<N; i++){
				double a = sc.nextInt()*0.35+sc.nextInt()*0.45+sc.nextInt()*0.2;
				st[i] = a;
				st2[i] = a;
			}
			Arrays.sort(st2);
			
			int idx = 0;
			for(int i=0; i<N; i++){
				if(st2[i] == st[K-1]){
					idx = N-1-i;
				}
			}
			String[] grade = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};
			
			System.out.println("#"+tc+" "+grade[idx/(N/10)]);

		}
	}
}
