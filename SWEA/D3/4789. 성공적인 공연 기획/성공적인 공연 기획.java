import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[] ch = sc.next().toCharArray();
			int count = 0;
			int ans = 0;
			for(int i=0; i<ch.length; i++){
				if(count>=i){
					count += ch[i]-'0';
				}else {
					ans++;
					count += (ch[i]-'0'+1);
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}

	}
}
