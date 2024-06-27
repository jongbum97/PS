import java.io.*;
import java.util.*;

public class Main {

	static int V, E, cost[][], BIG_INT = 1_000_000_000;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		cost = new int[V+1][V+1];
		for (int i=1; i<=V; i++){
			Arrays.fill(cost[i], BIG_INT);
		}
		for (int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			cost[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}

		for (int i=1; i<=V; i++){
			for(int j=1; j<=V; j++){
				for(int k=1; k<=V; k++){
					cost[i][k] = Math.min(cost[i][k], cost[i][j] + cost[j][k]);
				}
			}
		}

		int ans = BIG_INT;
		for (int i=1; i<=V; i++){
			ans = Math.min(ans, cost[i][i]);
		}
		if(ans >= BIG_INT) ans = -1;
		System.out.println(ans);

	}

}
