import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static long ans;
	static Queue<Node> q, put;
	static Queue<Integer> bag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<>((a,b) -> a.weight==b.weight? b.price-a.price:a.weight-b.weight);
		put = new PriorityQueue<>((a,b) -> b.price-a.price);
		bag = new PriorityQueue<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			q.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for(int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			bag.add(Integer.parseInt(st.nextToken()));
		}

		while(!bag.isEmpty()){
			int c = bag.remove();

			while(!q.isEmpty() && q.peek().weight <= c){
				put.add(q.remove());
			}

			if(!put.isEmpty()){
				ans += put.remove().price;
			}

		}

		System.out.println(ans);

	}

	static class Node{
		int weight;
		int price;
		Node(int weight, int price){
			this.weight = weight;
			this.price = price;
		}

	}

}
