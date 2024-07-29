import java.io.*;
import java.util.*;

public class Main {

	static int N, dr[] = {-1, 0, 1, 0}, dc[] = {0, 1, 0, -1};
	static char[][] map;
	static boolean[][][] visit;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][];
		visit = new boolean[N][N][2];
		for(int i=0; i<N; i++){
			map[i] = br.readLine().toCharArray();
		}

		Queue<Node> q = new ArrayDeque<>();
		outer: for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				if(map[i][j] == 'B'){
					if(i+1 < N && map[i+1][j] == 'B'){
						q.add(new Node(i+1, j, 1, 0));
						visit[i+1][j][1] = true;
					}else if(j+1 < N && map[i][j+1] == 'B'){
						q.add(new Node(i, j+1, 0, 0));
						visit[i][j+1][0] = true;
					}
					break outer;
				}
			}
		}

		while(!q.isEmpty()){

			Node n = q.remove();
			if(isEnd(n)){
				System.out.println(n.cnt);
				return;
			}

			for(int i=0; i<5; i++){
				Node nn = move(n, i);
				if(nn != null && !visit[nn.x][nn.y][nn.d]){
					q.add(nn);
					visit[nn.x][nn.y][nn.d] = true;
				}
			}

		}

		System.out.println(0);

	}

	static Node move(Node n, int d){
		if(d == 4){
			if(n.x-1<0 || n.x+1>N-1 || n.y-1<0 || n.y+1>N-1) return null;
			for(int i=-1; i<2; i++){
				for(int j=-1; j<2; j++){
					if(map[n.x+i][n.y+j] == '1') return null;
				}
			}
			return new Node(n.x, n.y, n.d==0? 1:0, n.cnt+1);
		}else{
			int a = n.x + dr[d];
			int b = n.y + dc[d];
			return check(new Node(a, b, n.d, n.cnt+1));
		}
	}

	static Node check(Node n){
		if(n.x<0 || n.x>N-1 || n.y<0 || n.y>N-1) return null;
		if(n.d == 0){
			if(n.y-1<0 || n.y+1>N-1 || map[n.x][n.y-1]=='1' || map[n.x][n.y]=='1' || map[n.x][n.y+1]=='1')
				return null;
		}else{
			if(n.x-1<0 || n.x+1>N-1 || map[n.x-1][n.y]=='1' || map[n.x][n.y]=='1' || map[n.x+1][n.y]=='1')
				return null;
		}
		return n;
	}

	static boolean isEnd(Node n){
		if(n.d == 0){
			if(map[n.x][n.y-1]!='E' || map[n.x][n.y]!='E' || map[n.x][n.y+1]!='E')
				return false;
		}else{
			if(map[n.x-1][n.y]!='E' || map[n.x][n.y]!='E' || map[n.x+1][n.y]!='E')
				return false;
		}
		return true;
	}

	static class Node{
		int x;
		int y;
		int d;
		int cnt;
		Node(int x, int y, int d, int cnt){
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}

}
