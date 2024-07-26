import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

	static int N, D, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		Queue<Node> q1 = new PriorityQueue<>((a,b) -> a.end-b.end);
		for(int i=0; i<N; i++){
			String[] input = br.readLine().split(" ");
			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
			if(a <= b){
				q1.add(new Node(a, b));
			}else{
				q1.add(new Node(b, a));
			}
		}
		D = Integer.parseInt(br.readLine());

		Queue<Node> q2 = new PriorityQueue<>((a,b) -> a.start-b.start);

		while(!q1.isEmpty()){

			Node n = q1.remove();
			if(n.end - n.start > D) continue;

			q2.add(n);
			while(!q2.isEmpty() && n.end-q2.peek().start > D){
				q2.remove();
			}

			ans = Math.max(ans, q2.size());

		}

		System.out.println(ans);

	}

	static class Node{
		int start;
		int end;
		Node(int start, int end){
			this.start = start;
			this.end = end;
		}
	}

}
