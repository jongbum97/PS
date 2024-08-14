import java.io.*;
import java.util.*;

public class Main {

	static int N, L, P, station[], ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		station = new int[1_000_001];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			station[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
		for(int i=1; i<=L; i++){
			P--;
			if(P < 0){
				if(!q.isEmpty()){
					P += q.remove();
					ans++;
				}else{
					System.out.println(-1);
					return;
				}
			}
			if(station[i] != 0)
				q.add(station[i]);
		}

		System.out.println(ans);

	}

}