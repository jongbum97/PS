import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int[] alphabet = new int[26];
			for(int i=0; i<N; i++){
				char c = sc.next().charAt(0);
				alphabet[c-'A']++ ;
			}
			
			int ans = 0;
			for(int i=0; i<26; i++){
				if(alphabet[i]!=0){
					ans++;
				}else {
					break;
				}
			}
			
			
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
			
		}
	}
	

}
