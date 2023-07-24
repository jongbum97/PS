import java.util.*;

public class Main {
	
	static int N, K;
	static boolean[] visit;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		visit = new boolean[N];
		for (int i = 0; i < N; i++) {
			list.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a==-1) {
				continue;
			}
			list.get(a).add(i);
		}
		K = sc.nextInt();
		
		
		del(K);
		for (int i = list.size()-1; i >=0; i--) {
			if (visit[i]) {
				list.get(i).clear();
			}
		}
		int KK = seek(K);
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				if (list.get(i).get(j)==K) {
					list.get(i).remove(j);
				}
			}
		}
		visit = new boolean[N];
		if (list.get(KK).size()==0 && KK==K) {
			System.out.println(0);
		}else {
			System.out.println(dfs(KK));
		}
	}

	static int dfs(int x) {
		
		visit[x] = true;
		if (list.get(x).size()==0) {
			return 1;
		}
		
		int sum = 0;
		for (int e : list.get(x)) {
			if (!visit[e]) {
				sum += dfs(e);
			}
		}
		
		return sum;
		
	}

	static void del(int x) {
	
		visit[x] = true;
		
		for (int e : list.get(x)) {
			del(e);
		}
	}
	
	static int seek(int x) {
		for (int i = 0; i < N; i++) {
			for (int e : list.get(i)) {
				if (x==e) {
					return seek(i);
				}
			}
		}
		return x;
	}

	
}
