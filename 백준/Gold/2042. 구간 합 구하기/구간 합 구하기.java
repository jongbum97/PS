import java.io.*;
import java.util.*;

public class Main {

	static int N, M, K, size;
	static long sum[], change[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		sum = new long[N+1];
		for(int i=1; i<=N; i++){
			sum[i] = sum[i-1] + Long.parseLong(br.readLine());
		}

		change = new long[M][2];
		size = 0;
		for(int i=0; i<M+K; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			if(a == 1){
				for(int j=0; j<size; j++){
					if(change[j][0] == b){
						change[j][1] = 0;
					}
				}
				change[size][0] = b;
				change[size++][1] = c-sum[b]+sum[b-1];
			}else{
				long ans = sum[(int)c]-sum[b-1];
				for(int j=0; j<size; j++){
					if(change[j][0] >= b && change[j][0] <= c){
						ans += change[j][1];
					}
				}
				sb.append(ans).append("\n");
			}
		}

		System.out.println(sb);

	}


}