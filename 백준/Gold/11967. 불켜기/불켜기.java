import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, map[][], dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1}, ans;
	static List<int[]>[][] line;
	static boolean[][] isLight, visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		isLight = new boolean[N][N];
		visit = new boolean[N][N];
		line = new List[N][N];
		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				line[i][j] = new ArrayList<>();
			}
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			line[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1].add(new int[]{Integer.parseInt(st.nextToken())-1, Integer.parseInt(st.nextToken())-1});
		}

		Queue<Node> q = new ArrayDeque<>();
		q.add(new Node(0, 0));
		isLight[0][0] = visit[0][0] = true;
		ans = 1;

		while(!q.isEmpty()){

			Node n = q.remove();
			for(int[] nn : line[n.x][n.y]){
				if(!isLight[nn[0]][nn[1]]){
					isLight[nn[0]][nn[1]] = true;
					ans++;
					for(int i=0; i<4; i++){
						int a = nn[0] + dr[i];
						int b = nn[1] + dc[i];
						if(a<0 || a>N-1 || b<0 || b>N-1 || !visit[a][b]) continue;
						q.add(new Node(nn[0], nn[1]));
						visit[nn[0]][nn[1]] = true;
					}
				}
			}

			for(int i=0; i<4; i++){
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0 || a>N-1 || b<0 || b>N-1 || !isLight[a][b] || visit[a][b]) continue;
				q.add(new Node(a, b));
				visit[a][b] = true;
			}

		}

		System.out.println(ans);

	}

	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

}