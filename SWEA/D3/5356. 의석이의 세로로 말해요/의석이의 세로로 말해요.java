import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[][] ch = new char[5][];
			for(int i=0; i<5; i++){
				ch[i] = sc.next().toCharArray();
			}
			
			String ans = "";
			for(int i=0; i<15; i++){
				for(int j=0; j<5; j++){
					if(i<ch[j].length){
						ans += ch[j][i];
					}
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
		}

	}
}
