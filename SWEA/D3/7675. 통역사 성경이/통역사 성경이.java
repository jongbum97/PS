import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] ans = new int[N];
			for(int i=0; i<N; ){
				String s = sc.next();
				if(s.charAt(0)>='A' && s.charAt(0)<='Z'){
					for(int j=1; j<s.length(); j++){
						if(s.charAt(j)>='a' && s.charAt(j)<='z'){
							
						}else if(s.charAt(j)=='!' || s.charAt(j)=='?' || s.charAt(j)=='.'){
							
						}else {
							break;
						}
						if(j==s.length()-1){
							ans[i]++;
						}
					}
					if(s.length()==1){
						ans[i]++;
					}
				}
				if(s.charAt(s.length()-1)=='!' || s.charAt(s.length()-1)=='?' || s.charAt(s.length()-1)=='.') {
					i++;
				}
				
			}
			
			
			
			
			System.out.print("#"+tc);
			for (int e : ans) {
				System.out.print(" "+e);
			}
			System.out.println();
		}
	}
	

}
