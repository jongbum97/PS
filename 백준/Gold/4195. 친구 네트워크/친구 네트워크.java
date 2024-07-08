import java.io.*;
import java.util.*;

public class Main {

	static int N, parent[], count[];
	static Map<String, Integer> name;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0){

			N = Integer.parseInt(br.readLine());
			name = new HashMap<>();
			parent = new int[2*N+1];
			count = new int[2*N+1];
			Arrays.fill(count, 1);
			for(int i=0; i<2*N+1; i++){
				parent[i] = i;
			}
			int cnt = 0;
			for(int i=0; i<N; i++){
				String[] input = br.readLine().split(" ");
				for(int j=0; j<2; j++){
					if(!name.containsKey(input[j])){
						name.put(input[j], cnt++);
					}
				}
				union(name.get(input[0]), name.get(input[1]));
				sb.append(count[find(name.get(input[0]))]).append("\n");
			}

		}

			System.out.println(sb);

	}

	static void union(int a, int b){
		a = find(a);
		b = find(b);
		if(a != b){
			parent[b] = a;
			count[a] += count[b];
		}
	}

	static int find(int n){
		if(parent[n] == n) return n;
		return parent[n] = find(parent[n]);
	}


}
