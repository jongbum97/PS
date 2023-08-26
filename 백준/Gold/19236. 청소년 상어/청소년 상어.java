import java.io.*;
import java.util.*;

public class Main {
	
	static int dr[]= {-1,-1,0,1,1,1,0,-1}, dc[]= {0,-1,-1,-1,0,1,1,1}, ans;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Node[][] map = new Node[4][4];
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				map[i][j] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())-1);
			}
		}
		Node n = map[0][0];
		map[0][0] = null;
		eat(map,0,0,n.direction,n.num);
		
		bw.write(ans+"\n");
		bw.close();
	}

	static void eat(Node[][] m, int x, int y, int d, int sum) {
	
		outer : for (int k = 1; k <= 16; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if(m[i][j]!=null && m[i][j].num==k) {
						int p = m[i][j].direction;
						while (true) {
							int a = i + dr[p%8];
							int b = j + dc[(p++)%8];
							if(a<0||a>3||b<0||b>3) continue;
							if(a==x&&b==y) continue;
							m[i][j].direction=(--p%8);
							Node tmp = m[i][j];
							m[i][j] = m[a][b];
							m[a][b] = tmp;
							break;
						}
						continue outer;
					}
				}
			}
		}

		for (int i = 1; i <= 3; i++) {
			int a = x + dr[d]*i;
			int b = y + dc[d]*i;
			if(a<0||a>3||b<0||b>3) continue;
			if(m[a][b]==null) continue;
			Node[][] m2 = new Node[4][4];
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					if (m[j][k]!=null) {
						m2[j][k] = new Node(m[j][k].num,m[j][k].direction);
					}
				}
			}
			Node n = m2[a][b];
			m2[a][b] = null;
			eat(m2, a, b, n.direction, sum+n.num);
		}
		
		ans = Math.max(ans, sum);
	}


	
	
}
class Node{
	int num;
	int direction;
	public Node(int num, int direction) {
		this.num = num;
		this.direction = direction;
	}
}