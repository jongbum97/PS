import java.io.*;
import java.util.*;

public class Main {
	
	static int A, B, C, D;
	static Set<Node> list;
	static boolean state;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = (A+B+C)/3;
		list = new HashSet<>();
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
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(A, B, C));
		
		while (!q.isEmpty()) {
			Node n = q.remove();
			if (n.a==D&&n.b==D&&n.c==D) {
				state = true;
				return;
			}
			
			if (list.contains(n)) {
				continue;
			}
			
			list.add(n);
			
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
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + b;
		result = prime * result + c;
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
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c != other.c)
			return false;
		return true;
	}

	
	
	
}