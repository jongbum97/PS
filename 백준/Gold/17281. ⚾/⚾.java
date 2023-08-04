import java.io.*;
import java.util.*;

public class Main {

	static int N, points[][], sum, ans;
	static boolean[] visit;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		points = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				points[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		visit = new boolean[9];
		aaa(0, new int[9]);
		System.out.println(ans);

	}

	static void aaa(int n, int[] b) {
		if (n == 3) {
			aaa(n + 1, b);
			return;
		}

		if (n == 9) {
			sum = 0;
			int p = 0;
			for (int i = 0; i < N; i++) {
				Game game = new Game();
				int j = p;
				while (!game.isEnd()) {

					game.game(points[i][b[j++ % 9]]);

				}
				sum += game.getScore();
				p = j % 9;
			}
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = 1; i < 9; i++) {
			if (visit[i])
				continue;
			visit[i] = true;
			b[n] = i;
			aaa(n + 1, b);
			visit[i] = false;
		}

	}

}

class Game {

	int score;
	int out;
	boolean firstBase;
	boolean secondBase;
	boolean thirdBase;

	boolean isEnd() {
		if (out < 3) {
			return false;
		} else {
			return true;
		}
	}

	int getScore() {
		return score;
	}

	void game(int n) {
		switch (n) {
		case 0:
			out++;
			return;
		case 1:
			first();
			return;
		case 2:
			second();
			return;
		case 3:
			third();
			return;
		case 4:
			fourth();
			return;
		}
	}

	void first() {
		if (thirdBase) {
			score++;
			thirdBase = false;
		}
		if (secondBase) {
			secondBase = false;
			thirdBase = true;
		}
		if (firstBase) {
			firstBase = false;
			secondBase = true;
		}
		firstBase = true;
	}

	void second() {
		if (thirdBase) {
			thirdBase = false;
			score++;
		}
		if (secondBase) {
			secondBase = false;
			score++;
		}
		if (firstBase) {
			firstBase = false;
			thirdBase = true;
		}
		secondBase = true;
	}

	void third() {
		if (thirdBase) {
			thirdBase = false;
			score++;
		}
		if (secondBase) {
			secondBase = false;
			score++;
		}
		if (firstBase) {
			firstBase = false;
			score++;
		}
		thirdBase = true;
	}

	void fourth() {
		if (thirdBase) {
			thirdBase = false;
			score++;
		}
		if (secondBase) {
			secondBase = false;
			score++;
		}
		if (firstBase) {
			firstBase = false;
			score++;
		}
		score++;
	}
}
