import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			char[] num = sc.next().toCharArray();
			
			int ans = 0;
			for(int i=0; i<num.length; i++){
				ans += num[i]-'0';
			}
			
			ans = ans%(N-1);
			
			
			
			
			
			
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
			
		}
	}
	

}
