import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			char[] doubles = sc.next().toCharArray();
			
			String ans = " Yes";
			for(int i=0; i<4; i++){
				if(ans.equals(" No")){
					break;
				}
				int count = 0;
				for(int j=0; j<4; j++){
					if(doubles[i]==doubles[j]){
						count++;
					}
					if(j==3 && count!=2){
						ans = " No";
					}
				}
				
			}
			
			System.out.println("#"+tc+ans);
			
		}
	}
}
