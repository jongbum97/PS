import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int dr[]= {-1,0,1,0}, dc[]= {0,1,0,-1};
		char[][] map = new char[N][];
		boolean[][][] visit = new boolean[N][M][1<<6];
		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int ans = -1;
		Queue<Node> q = new LinkedList<>();
		outer : for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j]=='0') {
					q.add(new Node(i, j, 0, 0));
					visit[i][j][0] = true;
					break outer;
				}
			}
		}
		
		while (!q.isEmpty()) {
			Node n = q.remove();
			
			if(map[n.x][n.y]=='1') {
				ans = n.cnt;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int a = n.x + dr[i];
				int b = n.y + dc[i];
				if(a<0||a>N-1||b<0||b>M-1) continue;
				char c = map[a][b];
				if(c=='#') continue;
				int key = n.key;
				if(c>='a'&&c<='f') {
					key = n.key|(1<<(c-'a'));
				}
				if(visit[a][b][key]) continue;
				if(c>='A'&&c<='F') {
					if((key&(1<<(c-'A')))==0) continue;
				}
				
				q.add(new Node(a, b, key, n.cnt+1));
				visit[a][b][key] = true;
			}
			
		}
		
		bw.write(ans+"\n");
		bw.close();
		
		
	}
	
}
class Node{
	int x;
	int y;
	int key;
	int cnt;
	Node(int x, int y, int key, int cnt){
		this.x = x;
		this.y = y;
		this.key = key;
		this.cnt = cnt;
	}
}