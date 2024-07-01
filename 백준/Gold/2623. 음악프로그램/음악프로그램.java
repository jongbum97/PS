import java.io.*;
import java.util.*;

public class Main {

	static int N, M, edgeCnt[];
	static List<Integer>[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new ArrayList[N+1];
		edgeCnt = new int[N+1];
		for(int i=1; i<=N; i++){
			line[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			for(int j=1; j<cnt; j++){
				int b = Integer.parseInt(st.nextToken());
				line[a].add(b);
				edgeCnt[b]++;
				a = b;
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++){
			if(edgeCnt[i] == 0){
				q.add(i);
			}
		}

		int cnt = 0;
		while(!q.isEmpty()){

			int n = q.remove();

			for(int nn : line[n]){
				if(--edgeCnt[nn] == 0){
					q.add(nn);
				}
			}

			sb.append(n).append("\n");
			cnt++;

		}
		
		if(cnt != N){
			sb = new StringBuilder("0\n");
		}
		System.out.println(sb);

	}


}
