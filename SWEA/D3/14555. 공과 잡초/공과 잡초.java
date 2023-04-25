import java.util.*;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			char[] pasture = sc.next().toCharArray();
			
			for(int i=0; i<pasture.length; i++){
				if(pasture[i]=='('){
					pasture[i+1] = ')';
				}else if (pasture[i]==')') {
					pasture[i-1] = '(';
				}
			}
			
			int ans = 0;
			for(int i=0; i<pasture.length-1; i++){
				if(pasture[i]=='(' && pasture[i+1]==')'){
					ans++;
				}
			}
			System.out.println("#"+tc+" "+ans);
			
		}

	}
}
