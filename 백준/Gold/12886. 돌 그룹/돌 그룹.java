import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, C, D;
	static boolean state, visit[][];
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = (A+B+C)/3;
		
		if ((A+B+C)%3==0) {
			BFS();
		}
		
		if (state) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
		
	}

	static void BFS() {
		visit = new boolean[760][760];
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(A, B, C));
		
		while (!q.isEmpty()) {
			Node n = q.remove();
			if (n.a==D&&n.b==D&&n.c==D) {
				state = true;
				return;
			}
			
			if (visit[n.a][n.b]) {
				continue;
			}
			
			visit[n.a][n.b]= true; 
			
			if (n.a>n.b) {
				q.add(new Node(n.a-n.b, 2*n.b, n.c));
			}else if (n.a<n.b) {
				q.add(new Node(n.a*2, n.b-n.a, n.c));
			}
			
			if (n.a>n.c) {
				q.add(new Node(n.a-n.c, n.b, n.c*2));
			}else if (n.a<n.c) {
				q.add(new Node(n.a*2, n.b, n.c-n.a));
			}
			
			if (n.b>n.c) {
				q.add(new Node(n.a, n.b-n.c, n.c*2));
			}else if (n.b<n.c) {
				q.add(new Node(n.a, n.b*2, n.c-n.b));
			}
		}
	}
}

class Node{
	int a;
	int b;
	int c;
	public Node(int a, int b, int c) {
		int[] n = {a, b, c};
		Arrays.sort(n);
		this.a = n[0];
		this.b = n[1];
		this.c = n[2];
	}
}