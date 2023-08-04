import java.io.*;
import java.util.*;

class Node{
	int p;
	int h;
	Node(int p, int h){
		this.p = p;
		this.h = h;
	}
}

public class Main {
	
	static int N, tops[], ans[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tops = new int[N+1];
		tops[0] = 100000000;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		ans = new int[N+1];
		Stack<Node> stack = new Stack<>();
		
		for (int i = N; i >= 1; i--) {
			if (tops[i-1] < tops[i]) {
				stack.add(new Node(i, tops[i]));
			}else {
				ans[i] = i-1;
				while (!stack.empty()) {
					Node n = stack.pop();
					if (tops[i-1]>=n.h) {
						ans[n.p] = i-1;
					}else {
						stack.add(n);
						break;
					}
				}
			}
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int i = 1; i <= N; i++) {
			bw.write(ans[i]+" ");
		}
		bw.close();
		
	}
	
	
}