import java.io.*;
import java.util.*;

public class Main {

	static int N, sum;
	static Queue<Node> list, solve;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new PriorityQueue<>((a,b) -> b.deadLine - a.deadLine);
		solve = new PriorityQueue<>((a,b) -> b.reward - a.reward);
		for(int i=0; i<N; i++){
			String[] input = br.readLine().split(" ");
			list.add(new Node(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
		}

		for(int i=N; i>0; i--){
			while(!list.isEmpty() && list.peek().deadLine >= i){
				solve.add(list.remove());
			}
			if(solve.isEmpty()) continue;

			sum += solve.remove().reward;
		}

		System.out.println(sum);

	}

	static class Node{
		int deadLine;
		int reward;
		Node(int deadLine, int reward){
			this.deadLine = deadLine;
			this.reward = reward;
		}
	}

}
