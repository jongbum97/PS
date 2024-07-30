import java.io.*;
import java.util.*;

public class Main {

	static int N, dp[], max;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		dp = new int[N+1];
		for(int i=0; i<N; i++){
			int k = Integer.parseInt(st.nextToken());
			dp[k] = dp[k-1] + 1;
			max = Math.max(max, dp[k]);
		}

		System.out.println(N-max);
	}

}
