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

	static int N;
	static boolean[][] map;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		String[][] s = new String[N][N];
		map = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			s[i] = sc.next().split("");
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (s[i][j].equals("1")) {
					map[i][j] = true;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j]) {
					BFS(i, j);
				}
			}
		}
		Collections.sort(arr);
		System.out.println(arr.size());
		for (int e : arr) {
			System.out.println(e);
		}
		
		
	}

	static void BFS(int x, int y) {
		int count = 1;
		map[x][y] = false;
		Node n = new Node(x, y);
		Queue<Node> queue = new LinkedList<>();
		queue.add(n);
		
		while (!queue.isEmpty()) {
			Node t = queue.remove();
			int p = t.x;
			int q = t.y;
			
			for (int i = 0; i < 4; i++) {
				int a = p + dr[i];
				int b = q + dc[i];
				if (a<0 || a>N-1 || b<0 || b>N-1) {
					continue;
				}else {
					if(map[a][b]){
						map[a][b] = false;
						Node nn = new Node(a, b);
						queue.add(nn);
						count++;
					}
				}
				
			}
			
		}
		
		arr.add(count);
		
		
	}


}