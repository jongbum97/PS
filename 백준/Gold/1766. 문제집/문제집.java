import java.io.*;
import java.util.*;

public class Main {

	static int N, M, edgeCount[];
	static List<Integer>[] list;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		edgeCount = new int[N+1];
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			edgeCount[b]++;
		}
		
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			if(edgeCount[i]==0) q.add(i);
		}
		
		while (!q.isEmpty()) {
			
			int k = q.remove();
			bw.write(k+" ");
			
			for (int i = 0; i < list[k].size(); i++) {
				int t = list[k].get(i);
				edgeCount[t]--;
				if(edgeCount[t]==0) {
					q.add(t);
				}
			}
			
		}
		
		bw.close();
	
	}
	
}