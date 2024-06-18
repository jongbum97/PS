import java.io.*;
import java.net.Inet4Address;
import java.util.*;

public class Main {

	static int N, K, dp[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");

		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);

		System.out.println(bfs());
		
	}

	public static int bfs(){
		dp = new int[200000];
		Arrays.fill(dp, Integer.MAX_VALUE);

		Queue<int[]> q = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
		dp[N] = 0;
		q.add(new int[]{N, 0});

		while (!q.isEmpty()){

			int[] n = q.poll();
//			System.out.println(Arrays.toString(n));
			if(n[0] == K) return dp[K];

			if(n[0] > 0 && dp[n[0]-1] > dp[n[0]] + 1){
				dp[n[0]-1] = dp[n[0]] + 1;
				q.offer(new int[]{n[0]-1, dp[n[0]-1]});
			}

			if(n[0] < K && n[0] < 199999 && dp[n[0]+1] > dp[n[0]] + 1){
				dp[n[0]+1] = dp[n[0]] + 1;
				q.offer(new int[]{n[0]+1, dp[n[0]+1]});
			}

			if(n[0] < K && n[0] < 100000 && dp[n[0]*2] > dp[n[0]]){
				dp[n[0]*2] = dp[n[0]];
				q.offer(new int[]{n[0]*2, dp[n[0]*2]});
			}

		}

		return dp[K];
	}

}
