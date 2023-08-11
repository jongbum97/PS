import java.io.*;
import java.util.*;

public class Main {

	static int N, K, homeWork[][], ans;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		homeWork = new int[N][];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			homeWork[i] = new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) };
		}

		Arrays.sort(homeWork, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				int k = Integer.compare(a[0], b[0]);
				if (k == 0) {
					return Integer.compare(a[1], b[1]);
				}
				return k;
			}
		});

		PriorityQueue<Integer> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			if (q.size() + 1 > homeWork[i][0]) {
				if (q.peek() < homeWork[i][1]) {
					q.remove();
					q.add(homeWork[i][1]);
				}
			} else {
				q.add(homeWork[i][1]);
			}
		}

		for (int e : q) {
			ans += e;
		}
		System.out.println(ans);

	}

}