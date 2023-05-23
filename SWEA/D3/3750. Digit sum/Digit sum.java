import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			String n = sc.next();
			
			while(n.length()>1){
				char[] ch = n.toCharArray();
				int k = 0;
				for(int i=0; i<ch.length; i++){
					k += ch[i]-'0';
				}
				n = k+"";
			}
			
	
			System.out.println("#"+tc+" "+n);
			
			
		}
	}
}
