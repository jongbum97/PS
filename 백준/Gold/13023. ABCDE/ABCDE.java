import java.util.*;

public class Main{

	static int N, M, ans;
	static boolean[] visit;
	static List<Integer>[] relation;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		relation = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			relation[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			relation[a].add(b);
			relation[b].add(a);
		}
		
		for (int i = 0; i < N; i++) {
			if (ans>3) {
				break;
			}
			visit = new boolean[N];
			DFS(i, 0);
		}
		if (ans>3) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
		
	}

	static void DFS(int x, int d) {
		if (ans>3) {
			return;
		}
		visit[x] = true;
		
		for (int r : relation[x]) {
			if (!visit[r]) {
				DFS(r, d+1);
			}
		}
	
		ans = Math.max(ans, d);
		visit[x] = false;
		
	}
	
	
}
