import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int T,n,d,c;
	static ArrayList<int[]>[] edge;
	static int[] dp;
	
	public static void main(String[] args) throws Exception {
		
		T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			
			dp = new int[n+1];
			edge = new ArrayList[n+1];
			Arrays.fill(dp, Integer.MAX_VALUE);
			
			for(int i=1;i<=n;++i) {
				edge[i] = new ArrayList<int[]>();
			}
			
			while(d-- > 0) {
				st = new StringTokenizer(br.readLine());
				
				int to = Integer.parseInt(st.nextToken());
				int from = Integer.parseInt(st.nextToken());
				int time = Integer.parseInt(st.nextToken());
			
				edge[from].add(new int[] {to,time});
			}
			
			findMinTime();
			findAns();
		}	
		System.out.println(sb);
	}
	
	static void findAns() {
		int cnt = 0;
		int t = 0;
		
		for(int i=1;i<=n;++i) {
			if(dp[i] != Integer.MAX_VALUE) {
				cnt++;
				t = Math.max(dp[i], t);
			}
		}
		
		sb.append(cnt+" " + t+"\n");
			
	}
	
	static void findMinTime() {
		
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {c,0});
		dp[c] = 0;// 감염 시작지
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			
			//현재 컴퓨터가 감염되었을 때 다음 지점가기
			for(int i=0;i<edge[cur[0]].size();++i) {
				
				int nxt = edge[cur[0]].get(i)[0];
				int nxtCost = edge[cur[0]].get(i)[1];
				
				//다음지점으로 가는게 더 최소비용일 때만
				if(dp[nxt] > dp[cur[0]] + nxtCost) {
					dp[nxt] = dp[cur[0]] + nxtCost;
					q.add(new int[] {nxt,dp[nxt]}); // 다음구간에 대해서 감염
				}
			}
		}
	}
 }
