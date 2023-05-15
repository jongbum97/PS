import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt();
			int M = sc.nextInt();
			String[] WinnerNumber = new String[N];
			int[] prize = new int[N];
			for(int i=0; i<N; i++){
				WinnerNumber[i] = sc.next();
				prize[i] = sc.nextInt();
			}
			
			int ans = 0;
			for(int i=0; i<M; i++){
				String nums = sc.next();
				outer : for(int j=0; j<N ; j++){
					for(int k=0; k<8 ; k++){
						if(WinnerNumber[j].charAt(k)!='*' && WinnerNumber[j].charAt(k)!=nums.charAt(k)){
							continue outer;
						}
					}
					ans += prize[j];
					break;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
			
			
			
		}
	}
	

}
