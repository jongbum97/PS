import java.io.*;
import java.util.*;

public class Main {

	static int N, ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			q.add(Integer.parseInt(br.readLine()));
		}
		
		while (q.size()>1) {
			int k = q.remove()+q.remove();
			q.add(k);
			ans += k;
		}
		
		System.out.println(ans);
		
	}
}