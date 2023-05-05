import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i<N; i++){
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			
			String ans = "Yes";
			for(int i=0; i<N; i++){
				if(arr[i] != i+1){
					ans = "No";
					break;
				}
			}
			
			System.out.println("#"+tc+" "+ans);
		}
	}
	

}
