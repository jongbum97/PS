import java.io.*;
import java.util.*;

public class Main {

	static int N, M, line[][], parents[];
	static Set<Integer> set;
	static boolean ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		line = new int[N+1][N+1];
		
		make();
//		System.out.println(Arrays.toString(parents));
		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				int a = Integer.parseInt(st.nextToken());
				if(a==1) {
					union(i, j);
				}
			}
		}
//		System.out.println(Arrays.toString(parents));
		
		set = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
//		System.out.println(set);
		Iterator<Integer> it = set.iterator();
		int k = it.next();
//		System.out.println(k);
		ans = true;
		while (it.hasNext()) {
			if(find(k)!=find(it.next())) {
				ans = false;
				break;
			}
		}
		
		if (ans) {
			bw.write("YES\n");
		}else {
			bw.write("NO\n");
		}
		
		bw.close();
	
	}
	
	static void make() {
		parents = new int[N+1];
		for (int i = 1; i <= N; i++) {
			parents[i] = i;
		}
	}

	static int find(int x) {
		if(parents[x]==x) return x;
		return find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int a = find(x);
		int b = find(y);
		if(a==b) return false;
		parents[b] = a;
		return true;
	}
	
}