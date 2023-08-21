import java.io.*;
import java.util.*;

public class Main {

	static int N, M, edgeCount[], ans[];
	static List<int[]>[] list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		list = new ArrayList[N+1];
		edgeCount = new int[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			list[a].add(new int[] {b, c});
			edgeCount[b]++;
		}

		
		ans = new int[N+1];
		Queue<Integer> q = new LinkedList<>();
		ans[N] = 1;
		q.add(N);
		
		while (!q.isEmpty()) {
			
			int k = q.remove();
			for (int[] li : list[k]) {
				ans[li[0]] += li[1]*ans[k];
				edgeCount[li[0]]--;
				if(edgeCount[li[0]]==0) {
					q.add(li[0]);
				}
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (list[i].size()>0) continue;
			bw.write(i+" "+ans[i]+"\n");
		}
		
		bw.close();
	
	}

	
}