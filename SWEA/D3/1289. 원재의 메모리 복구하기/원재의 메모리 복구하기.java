import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			String memory = sc.next();
			memory = "0"+memory;
			int N = memory.length();
			
			int ans = 0;
			
			for(int i=0; i<N-1; i++){
				if(memory.charAt(i) != memory.charAt(i+1)){
					ans++;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
		
			
		}
	}
}
