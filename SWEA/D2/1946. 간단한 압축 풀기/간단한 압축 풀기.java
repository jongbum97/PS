import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String ans = "";
			for(int i=0; i<N; i++){
				String str = sc.next();
				int a = sc.nextInt();
				for(int j=0; j<a; j++){
					if(ans.length()%11==0){
						ans += "\n";
					}
					ans += str;
				}
			}
			
			System.out.println("#"+tc+" "+ans);

		}
	}
}
