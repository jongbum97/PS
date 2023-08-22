import java.io.*;
import java.util.*;

public class Main {

	static int N, M, line[][], parents[], know[], ans;
	static List<Integer>[] list;
	static boolean party[];


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
		st = new StringTokenizer(br.readLine());
		int p = Integer.parseInt(st.nextToken());
		know = new int[p];
		for (int i = 0; i < p; i++) {
			know[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			for (int j = 0; j < t; j++) {
				list[Integer.parseInt(st.nextToken())].add(i);
			}
		}
		
//		for (int i = 1; i <= N; i++) {
//			System.out.println(list[i]);
//		}
		
		make();
//		System.out.println(Arrays.toString(parents));
		for (int i = 1; i <= N; i++) {
			for (int j = 0; j < list[i].size()-1; j++) {
				union(list[i].get(j), list[i].get(j+1));
			}
		}
//		System.out.println(Arrays.toString(parents));
		
		party = new boolean[M+1];
		for (int i = 0; i < p; i++) {
			if(list[know[i]].size()==0) continue;
			int a = list[know[i]].get(0);
			int b = find(a);
			for (int j = 1; j <= M; j++) {
				if(find(j)==b) party[j] = true;
			}
		}
		for (int i = 1; i <= M; i++) {
			if(!party[i]) ans++;
		}
		
		bw.write(ans+"\n");
		bw.close();
	
	}
	
	static void make() {
		parents = new int[M+1];
		for (int i = 1; i <= M; i++) {
			parents[i] = i;
		}
	}
	
	static int find(int x) {
		if (parents[x] == x) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a!=b) parents[b] = a;
	}

}