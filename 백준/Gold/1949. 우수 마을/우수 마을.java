import java.io.*;
import java.util.*;

public class Main {

	static int N, residents[], dp[][];
	static List<Integer> line[];
	static boolean[] isSelected;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		residents = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++){
			residents[i] = Integer.parseInt(st.nextToken());
		}
		line = new List[N+1];
		for(int i=1; i<=N; i++){
			line[i] = new ArrayList<>();
		}
		for(int i=1; i<N; i++){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			line[a].add(b);
			line[b].add(a);
		}

		dp = new int[N+1][2];
		isSelected = new boolean[N+1];
		dfs(1);

		 System.out.println(Math.max(dp[1][0], dp[1][1]));
	}

	static void dfs(int n){

		isSelected[n] = true;

		for(int nn : line[n]){
			if(isSelected[nn]) continue;
			dfs(nn);
			dp[n][0] += Math.max(dp[nn][0], dp[nn][1]);
			dp[n][1] += dp[nn][0];
		}

		dp[n][1] += residents[n];

	}


}
