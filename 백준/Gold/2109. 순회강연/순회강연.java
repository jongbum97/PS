import java.io.*;
import java.util.*;

public class Main {

	static int N, speech[][], ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N==0) {
			System.out.println(0);
			return;
		}
		speech = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			speech[i] = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		Arrays.sort(speech, (a,b)->b[1]-a[1]);
		
		PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
		int count = 0;
		
		for (int i = speech[0][1]; i > 0 ; i--) {
			while (count<N && i<=speech[count][1]) {
				q.add(speech[count++][0]);
			}
			if(!q.isEmpty()) ans += q.remove();
		}
		
		System.out.println(ans);
		
	}

}