import java.io.*;
import java.util.*;

public class Main {

	static int N, K;
	static long ans;
	static Queue<Jewelry> q;
	static Queue<Node> put;
	static Queue<Integer> bag;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		q = new PriorityQueue<>();
		put = new PriorityQueue<>();
		bag = new PriorityQueue<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			q.add(new Jewelry(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		for(int i=0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			bag.add(Integer.parseInt(st.nextToken()));
		}

		while(!bag.isEmpty()){
			int c = bag.remove();

			while(!q.isEmpty() && q.peek().weight <= c){
				Jewelry j = q.remove();
				put.add(new Node(j.weight, j.price));
			}

			if(!put.isEmpty()){
				ans += put.remove().price;
			}

		}

		System.out.println(ans);

	}

	static class Jewelry implements Comparable<Jewelry>{
		int weight;
		int price;
		Jewelry(int weight, int price){
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Jewelry o) {
			return this.weight==o.weight? o.price-this.price:this.weight-o.weight;
		}
	}

	static class Node implements Comparable<Node>{
		int weight;
		int price;
		Node(int weight, int price){
			this.weight = weight;
			this.price = price;
		}

		@Override
		public int compareTo(Node o) {
			return o.price-this.price;
		}
	}

}
