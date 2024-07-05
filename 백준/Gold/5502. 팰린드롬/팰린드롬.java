import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static char letter[];
	static boolean flag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		letter = br.readLine().toCharArray();

		int ans = N - 2*dp1() - (flag? 0:1);
		System.out.println(ans);


	}

	static int dp1(){
		int[][] dp = new int[N+2][N+2];
		int ans = 0;

		for(int i=1; i<=N; i++){
			int cnt = 0;
			boolean b = false;
			for(int j=N; j>i; j--){
				dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j]);
				if(letter[i-1] == letter[j-1]){
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j+1] + 1);
				}
				if(cnt < dp[i][j]){
					cnt = dp[i][j];
                    b = j - i == 1;
				}
			}
			if(cnt > ans){
				flag = b;
				ans = cnt;
			}else if(cnt == ans){
				flag = flag && b;
			}
		}

		return ans;
	}


}
