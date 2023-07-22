import java.util.*;

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class Main {

	static int M, N, K;
	static boolean[][] area;
	static ArrayList<Integer> list = new ArrayList<>();
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		area = new boolean[M][N];
		for (int i = 0; i < K; i++) {
			int b = sc.nextInt();
			int a = sc.nextInt();
			int d = sc.nextInt();
			int c = sc.nextInt();
			for (int j = a; j < c; j++) {
				for (int k = b; k < d; k++) {
					area[j][k] = true;
				}
			}
		}
		
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!area[i][j]) {
					BFS(i, j);
				}
			}
		}
		
		System.out.println(list.size());
		Collections.sort(list);
		for (int i : list) {
			System.out.print(i+" ");
		}
		
	}
	
	static void BFS(int x, int y){
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		area[x][y] = true;
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			Node n = queue.remove();
			int p = n.x;
			int q = n.y;
			for (int i = 0; i < 4; i++) {
				int a = p + dr[i];
				int b = q + dc[i];
				
				if (a<0 || a>M-1 || b<0 || b>N-1) {
					continue;
				}else {
					if (!area[a][b]) {
						queue.add(new Node(a, b));
						area[a][b] = true;
					}
				}
			}
		}
		
		list.add(count);
		
	}
	
	
}
