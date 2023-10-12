import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M, from[], dis[], min, ans, INF=Integer.MIN_VALUE;
	static List<int[]>[] list;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N+1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list[Integer.parseInt(st.nextToken())].add(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
		}
		
		// from배열은 경로를 저장하는 배열, dis배열을 금품의 최댓값을 저장하는 배열
		from = new int[N+1];
		dis = new int[N+1];
		Arrays.fill(dis, INF);
		dis[1] = 0;

		// 밸만포드 실행
		for (int t = 0; t < N; t++) {
			BellmanFord();
		}
		
		// 음의 사이클을 확인하기 위해 한번 더 실행. 음의사이클이 존재해도 최대이익 경로에는 지장을 안 줄 수도 있으므로 목적지의 최대이익수치만 확인
		int[] tmp = dis.clone();
		for (int t = 0; t < 100*N; t++) {
			BellmanFord();
		}

		if(tmp[N] != dis[N]) {
			System.out.println(-1);
			return;
		}
		
		// 애당초 목적지에 도달할 수 없는경우 -1
		if(dis[N]==INF) {
			System.out.println(-1);
			return;
		}
		
		// 경로를 처음부터 출력해야 해서 stack에 담은후 역순으로 꺼내 출력
		int idx = N;
		Stack<Integer> stack = new Stack<>();
		while (idx != 0) {
			stack.add(idx);
			idx = from[idx];
		}
		
		while (!stack.isEmpty()) {
			int k = stack.pop();
			sb.append(k).append(" ");
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void BellmanFord() {
		for (int i = 1; i < N; i++) {
			if(dis[i]==INF) continue;
			for (int[] e : list[i]) {
				if(dis[e[0]] < dis[i] + e[1]) {
					dis[e[0]] = dis[i] + e[1];
					from[e[0]] = i;
				}
			}
		}
	}
	
}