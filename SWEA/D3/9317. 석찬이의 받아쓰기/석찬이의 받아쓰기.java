import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			char[] coAns = sc.next().toCharArray();
			char[] Ans = sc.next().toCharArray();
			int ans = 0;
			for(int i=0; i<N; i++){
				if(coAns[i]==Ans[i]){
					ans++;
				}
			}
			
			

			System.out.println("#" + tc + " "+ans);
			
		}

	}
}
