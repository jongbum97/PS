import java.io.*;
import java.util.*;

public class Main {

	static int N, M, ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			Queue<Node> student = new PriorityQueue<>((a,b) -> a.from - b.from);
			for(int i=0; i<M; i++){
				st = new StringTokenizer(br.readLine());
				student.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}

			Queue<Node> give = new PriorityQueue<>((a,b) -> a.to - b.to);
			ans = 0;
			for(int i=1; i<=N; i++){

				while(!student.isEmpty() && student.peek().from == i){
					give.add(student.remove());
				}
				while(!give.isEmpty()){
					Node n = give.remove();
					if(n.to >= i){
						ans++;
						break;
					}
				}

			}

			System.out.println(ans);

		}

	}

	static class Node {
		int from;
		int to;
		Node(int from, int to){
			this.from = from;
			this.to = to;
		}
	}

}
