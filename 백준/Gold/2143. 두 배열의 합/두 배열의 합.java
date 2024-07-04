import java.io.*;
import java.util.*;

public class Main {

	static int T, A[], B[], N, M, sA[];
	static Map<Integer, Integer> sB;
	static long ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<=N; i++){
			A[i] = A[i-1] + Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		B = new int[M+1];
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=M; i++){
			B[i] = B[i-1] + Integer.parseInt(st.nextToken());
		}

		sA = new int[N*(N+1)/2];
		int cnt = 0;
		for(int i=0; i<=N; i++){
			for(int j=i+1; j<=N; j++){
				sA[cnt++] = A[j] - A[i];
			}
		}

		sB = new HashMap<>();
		for(int i=0; i<=M; i++){
			for(int j=i+1; j<=M; j++){
				sB.put(B[j] - B[i], sB.getOrDefault(B[j] - B[i], 0) + 1);
			}
		}

		for(int n : sA){
			ans += sB.getOrDefault(T - n, 0);
		}

		System.out.println(ans);

	}


}
