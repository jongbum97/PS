import java.util.*;

public class Solution {
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			int ans = 0;
			for(int i=2; i<1000000000; i++){
				if(num(i) && num(i+N)){
					ans = i;
					break;
				}
			}
			
			System.out.println("#"+tc+" "+(ans+N)+" "+ans);
			
			
			
		}

	}
	
	static boolean num(int n) {
		if(n<3){
			return false;
		}
		for(int i=2; i<=Math.pow(n, 0.5); i++){
			if(n%i==0){
				return true;
			}
		}
		return false;
	}
	
	
	
}
