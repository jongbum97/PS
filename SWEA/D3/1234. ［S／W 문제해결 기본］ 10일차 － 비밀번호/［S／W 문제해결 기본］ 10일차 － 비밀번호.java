import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int N = sc.nextInt();
			ArrayList<String> arr = new ArrayList<>();
			String str = sc.next();
			for (int i = 0; i < N; i++) {
				arr.add(i, str.charAt(i) + "");
			}

			boolean boo = true;
			while (boo) {
				int A = N;
				for (int i = 0; i < N - 1; i++) {
					if (arr.get(i).equals(arr.get(i + 1))) {
						arr.remove(i + 1);
						arr.remove(i);
						N -= 2;
					}
				}
				if (A == N) {
					boo = false;
				} else {
					continue;
				}
			}

			System.out.print("#" + tc + " ");
			for (String e : arr) {
				System.out.print(e);
			}
			System.out.println();

		}

	}
}
