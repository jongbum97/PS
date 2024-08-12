import java.io.*;
import java.util.*;

public class Main {

	static int N, edgeCnt[];
	static List<Integer>[] line;
	static boolean[] visit, isEarly;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		line = new List[N+1];
		edgeCnt = new int[N+1];
		visit = new boolean[N+1];
		isEarly = new boolean[N+1];
		for(int i=1; i<=N; i++){
			line[i] = new ArrayList<>();
		}
		for(int i=1; i<N; i++){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			line[a].add(b);
			line[b].add(a);
			edgeCnt[a]++;
			edgeCnt[b]++;
		}

		Queue<Integer> q = new ArrayDeque<>();
		for(int i=1; i<=N; i++){
			if(edgeCnt[i] == 1){
				q.add(i);
			}
		}

		while(!q.isEmpty()){

			Integer n = q.remove();

			if(visit[n]) continue;
			visit[n] = true;

			for(Integer nn : line[n]){
				if(visit[nn]) continue;
				edgeCnt[n]--;
				edgeCnt[nn]--;
				if(!isEarly[n]){
					isEarly[nn] = true;
				}
				if(edgeCnt[nn] < 2){
					q.add(nn);
				}
				break;
			}

		}

		int ans = 0;
		for(int i=1; i<=N; i++){
			if(isEarly[i]) ans++;
		}
		System.out.println(ans);

	}

}