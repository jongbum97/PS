import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			char[] ch = sc.next().toCharArray();
			int ans = 1;
			for(int i=1; i<ch.length-1; i++){
				if(ch[0]!=ch[i] ||ch[1]!=ch[i+1]){
					ans++;
				}else {
					break;
				}
			}

			
			System.out.println("#"+tc+" "+ans);

		}
	}
}
