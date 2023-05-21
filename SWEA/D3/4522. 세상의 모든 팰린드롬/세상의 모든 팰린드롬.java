import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			char[] ch = sc.next().toCharArray();
			int N = ch.length;
			
			String ans = "Exist";
			for(int i=0; i<N/2; i++){
				if(ch[i]=='?' || ch[N-1-i]=='?'){
					continue;
				}else if (ch[i]!=ch[N-1-i]) {
					ans = "Not exist";
					break;
				}
			}
			
			
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}
	}
}
