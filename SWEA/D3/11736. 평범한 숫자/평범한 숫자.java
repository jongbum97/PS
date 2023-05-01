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
			
			int ans = 0;
			for(int i=1; i<=N-2; i++){
				if(arr[i]>Math.min(arr[i-1], arr[i+1]) && arr[i]<Math.max(arr[i-1], arr[i+1])){
					ans++;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
}
