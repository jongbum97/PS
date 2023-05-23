import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<N; i++){
				sb.append(sc.next());
			}
			
			int ans = 0;
			for(int i=0; i<10000; i++){
				ans = i;
				String str = sb.toString();
				if(str.equals(str.replace(i+"", "@"))){
					break;
				}
			}
			
	
			System.out.println("#"+tc+" "+ans);
			
			
		}
	}
}
