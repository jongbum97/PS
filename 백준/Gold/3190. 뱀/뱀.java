import java.util.*;
import java.io.*;

public class Main {

	static int N, K, L, apple[][], turn[][], a, b, dr[]= {-1, 0, 1, 0}, dc[]= {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		apple = new int[K][2];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			apple[i][0] = Integer.parseInt(st.nextToken())-1;
			apple[i][1] = Integer.parseInt(st.nextToken())-1;
		}
		L = Integer.parseInt(br.readLine());
		turn = new int[L][2];
		for (int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			turn[i][0] = Integer.parseInt(st.nextToken());
			turn[i][1] = st.nextToken().charAt(0);
		}
		
		Deque<Node> dq = new ArrayDeque<>();
		dq.add(new Node(0,0));
		
		int i = 1;
		int t = 0;
		
		while(true) {
			for (int j = 0; j < L; j++) {
				if(turn[j][0] > t) break;
				if (turn[j][0] == t) {
					if (turn[j][1]=='D') {
						i++;i%=4;
					}else {
						i--;
						if(i<0) i+=4;
					}
					break;
				}
			}
			a+=dr[i];b+=dc[i];
			if (a<0||a>N-1||b<0||b>N-1) {
				t++;
				break;
			}
			if (dq.contains(new Node(a,b))) {
				t++;
				break;
			}
			dq.addLast(new Node(a,b));
			
			boolean state = false;
			for (int j = 0; j < K; j++) {
				if (apple[j][0]==a && apple[j][1]==b) {
					state = true;
					apple[j][0]=-1;
					apple[j][1]=-1;
					break;
				}
			}
			if (!state) {
				dq.removeFirst();
			}
			t++;
		}
		System.out.println(t);
		
	}
	
}

class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}