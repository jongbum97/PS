import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			
			System.out.println("#"+tc+" "+(N/30)%12+" "+(N-((N/30)%12)*30)*2);
		}
	}
	

}
