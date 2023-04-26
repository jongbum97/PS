import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int r = sc.nextInt();
			
			int ans = 0;
			for(int i=-r; i<=r; i++){
				for(int j=-r; j<=r ; j++){
					if((i*i+j*j)<=r*r){
						ans++;
					}
				}
			}
			
			
			
			System.out.println("#"+tc+" "+ans);
			
		}

	}
}
