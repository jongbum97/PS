import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			char[] ch = sc.next().toCharArray();
			
			
			int ans = 1;
			for(int i=0; i<ch.length/2; i++){
				if(ch[i]!=ch[ch.length-i-1]){
					ans = 0;
					break;
				}
			}
			
			

			System.out.println("#"+tc+" "+ans);

		}
	}
}
