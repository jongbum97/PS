import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			char[] win = sc.next().toCharArray();
			
			int lose = 0;
			for(int i=0; i<win.length; i++){
				if(win[i]=='x'){
					lose++;
				}
			}
			if(lose>7){
				System.out.println("#"+tc+" NO");
			}else {
				System.out.println("#"+tc+" YES");
			}
		}
	}
}