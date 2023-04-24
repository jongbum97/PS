import java.util.*;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String str1 = sc.next();
			String str2 = sc.next();
			int s1 = str1.length();
			int s2 = str2.length();
			
			String ans1 = "";
			String ans2 = "";
			
			for(int i=0; i<s2; i++){
				ans1 += str1;
			}
			for(int i=0; i<s1; i++){
				ans2 += str2;
			}
			
			if(ans1.equals(ans2)){
				System.out.println("#"+tc+" yes");
			}else {
				System.out.println("#"+tc+" no");
			}
			
			
			
			
		}

	}
}
