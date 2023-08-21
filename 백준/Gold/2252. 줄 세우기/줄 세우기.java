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
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		edgeCount = new int[N+1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			edgeCount[b]++;
		}
		
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if(edgeCount[i]==0) q.add(i);
		}
		
		while (!q.isEmpty()) {
			
			int n = q.remove();
			
			for (int e : list[n]) {
				edgeCount[e]--;
				if (edgeCount[e]==0) {
					q.add(e);
				}
			}
			
			bw.write(n+" ");
			
		}
		
		
		bw.close();
		
		
	}
	
}