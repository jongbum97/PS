import java.io.*;
import java.util.*;

public class Main {

	static int N, M;
	static List<Integer>[] line;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		line = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			line[i] = new ArrayList<>();
		}
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			int[] nums = new int[cnt];
			for(int j=0; j<cnt; j++){
				nums[j] = Integer.parseInt(st.nextToken());
			}
			for(int j=0; j<cnt; j++){
				for(int k=j+1; k<cnt; k++){
					line[nums[k]].add(nums[j]);
				}
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for(int i=1; i<=N; i++){
			if(line[i].isEmpty()){
				q.add(i);
				line[i].add(-1);
			}
		}

		int cnt = 0;
		while(!q.isEmpty()){

			int n = q.remove();

			for(int i=1; i<=N; i++){
				for(int j=line[i].size()-1; j>=0; j--){
					if(line[i].get(j).equals(n)) {
						line[i].remove(j);
					}
				}
				if(line[i].isEmpty()){
					q.add(i);
					line[i].add(-1);
				}
			}
			sb.append(n).append("\n");
			cnt++;

		}
		if(cnt != N){
			sb = new StringBuilder("0\n");
		}

		System.out.println(sb);

	}


}
