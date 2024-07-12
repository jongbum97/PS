import java.io.*;
import java.util.*;

public class Main {

	static int N, px, min[], max[], ans, ansIdx;
	static Node[] nodes;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		nodes = new Node[N+1];
		for(int i=1; i<=N; i++){
			nodes[i] = new Node(1, null, null, null);
		}
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(b != -1){
				nodes[a].left = nodes[b];
				nodes[b].parent = nodes[a];
			}
			if(c != -1){
				nodes[a].right = nodes[c];
				nodes[c].parent = nodes[a];
			}
		}

		max = new int[N+1];
		min = new int[N+1];
		Arrays.fill(min, Integer.MAX_VALUE);
		for(int i=1; i<=N; i++){
			if(nodes[i].parent == null){
				search(nodes[i], 1);
				break;
			}
		}

		ansIdx = 1;
		ans = 0;
		for(int i=1; i<=N; i++){
			if(max[i] == 0 || min[i] == Integer.MAX_VALUE) break;
			int k = max[i] - min[i];
			if(ans < k){
				ansIdx = i;
				ans = k;
			}
		}

		System.out.println(ansIdx+" "+(ans+1));


	}

	static void search(Node n, int level){

		if(n.left != null)
			search(n.left, level+1);

		n.x = ++px;
		max[level] = Math.max(max[level], n.x);
		min[level] = Math.min(min[level], n.x);

		if(n.right != null)
			search(n.right, level+1);

	}

	static class Node{
		int x;
		Node parent;
		Node left;
		Node right;
		Node(int x, Node parent, Node left, Node right){
			this.x = x;
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
	}

}
