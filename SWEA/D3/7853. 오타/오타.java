import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[] word = sc.next().toCharArray();
			
			long ans = 1;
			for(int i=0; i<word.length; i++){
				int count = 1;
				if(i>0 && i<word.length-1) {
					if(word[i-1]!=word[i]){
						count++;
					}
					if(word[i+1]!=word[i] && word[i+1]!=word[i-1]){
						count++;
					}
				}else if (i==0) {
					if(word[i+1]!=word[i]){
						count++;
					}
				}else {
					if(word[i-1]!=word[i]){
						count++;
					}
				}
				ans *= count;
				ans %= 1000000007;
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
