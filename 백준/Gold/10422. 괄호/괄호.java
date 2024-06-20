import java.io.*;
import java.util.*;

public class Main {

	static int T, L, dp[][];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringBuilder sb = new StringBuilder();

		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++){

			L = Integer.parseInt(br.readLine());
			dp = new int[L+1][L/2+1];
			if(L%2 == 0){
				dfs(0, 0);
			}

			System.out.println(dp[0][0]);

		}


	}

	private static int dfs(int x, int cnt) {
//		System.out.println(x+", "+cnt);

		if(x == L){
//			ans = (++ans)%1000000007;
			return 1;
		}

		int a = 0, b = 0;
		if(L/2 > x - cnt){
			if(dp[x+1][cnt] == 0){
				a = dfs(x + 1, cnt);
			}else{
				a = dp[x+1][cnt];
			}
		}

		if((x+1)/2 > cnt){
			if(dp[x+1][cnt+1] == 0){
				b = dfs(x + 1, cnt + 1);
			}else{
				b = dp[x+1][cnt+1];
			}

		}

		return dp[x][cnt] = (a+b)%1000000007;

	}


}
