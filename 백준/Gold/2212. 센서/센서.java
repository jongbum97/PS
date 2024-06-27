import java.io.*;
import java.util.*;

public class Main {

	static int N, K, sensor[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		sensor = new int[N];
		for (int i=0; i<N; i++){
			sensor[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(sensor);
		int start = sensor[0];
		for (int i=0; i<N; i++){
			sensor[i] -= start;
		}

		int[] length = new int[N-1];
		for (int i=0; i<N-1; i++){
			length[i] = sensor[i+1] - sensor[i];
		}
		Arrays.sort(length);

		int ans = 0;
		for (int i=0; i<N-1-K+1; i++){
			ans += length[i];
		}
		System.out.println(ans);

	}

}
