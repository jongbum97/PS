import java.util.*;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int N, ans, idx;
	static int[][] area;
	static boolean[][] visit;
	static int[][] dis;
	static int[] dr = { -1, 0, 0, 1 };
	static int[] dc = { 0, -1, 1, 0 };
	static Node B;
	static int size = 2;
	static int eat;
	static int state;
	static int pp = -1;
	static ArrayList<int[]> list = new ArrayList<>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		area = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int a = sc.nextInt();
				area[i][j] = a;
				if (a == 9) {
					B = new Node(i, j);
				}
			}
		}

		while (state != 1) {
			BFS(B);
		}
		System.out.println(ans);

	}

	static void BFS(Node n) {
		pp = -1;
		Queue<Node> queue = new LinkedList<>();
		list.clear();
		dis = new int[N][N];
		visit = new boolean[N][N];
		queue.add(n);
		visit[n.x][n.y] = true;
		area[n.x][n.y] = 0;

		while (!queue.isEmpty()) {
			
			Node nn = queue.remove();
			int x = nn.x;
			int y = nn.y;

			for (int i = 0; i < 4; i++) {
				int a = x + dr[i];
				int b = y + dc[i];
				if (a < 0 || a > N - 1 || b < 0 || b > N - 1) {
					continue;
				}else {
					if (!visit[a][b] && area[a][b]<=size) {
						queue.add(new Node(a, b));
						visit[a][b] = true;
						dis[a][b] = dis[x][y] +1;
						if (area[a][b]!=0 && area[a][b]<size) {
							if (pp==-1) {
								list.add(new int[] {a, b});
								pp = dis[a][b];
							}else {
								if (dis[a][b]==pp) {
									list.add(new int[] {a, b});
								}
							}
						}
					}
				}
			}
		}
		
		if (list.size()==0) {
			state = 1;
			return;
		}else {
			int l = list.size()-1;
			for (int i = 0; i < l; i++) {
				if (list.get(i)[0]<list.get(i+1)[0]) {
					int[] tmp = list.get(i+1).clone();
					list.remove(i+1);
					list.add(i, tmp);
				}else if (list.get(i)[0]==list.get(i+1)[0]) {
					if (list.get(i)[1]<list.get(i+1)[1]) {
						int[] tmp = list.get(i+1).clone();
						list.remove(i+1);
						list.add(i, tmp);
					}
				}
			}
			
			int h = list.get(l)[0];
			int j = list.get(l)[1];
			B = new Node(h, j);
			area[h][j] = 0;
			eat++;
			if (eat==size) {
				size++;
				eat = 0;
			}
			ans += dis[h][j];
		}
		
		
		
		

	}

}
