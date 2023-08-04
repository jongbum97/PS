import java.io.*;
import java.math.BigInteger;
import java.util.*;

class Compa implements Comparator<BigInteger> {

	@Override
	public int compare(BigInteger o1, BigInteger o2) {
		if (o1.abs().equals(o2.abs())) {
			if (o1.subtract(o2).compareTo(BigInteger.ZERO) > 0) {
				return 1;
			} else {
				return -1;
			}
		}
		return o1.abs().subtract(o2.abs()).compareTo(BigInteger.ZERO);
	}
}

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		PriorityQueue<BigInteger> q = new PriorityQueue<>(new Compa());
		for (int i = 0; i < N; i++) {

			BigInteger b = new BigInteger(br.readLine());
			if (b.equals(BigInteger.ZERO)) {
				if (q.isEmpty()) {
					bw.write(0 + "\n");
				} else {
					bw.write(q.remove() + "\n");
					;
				}
			} else {
				q.add(b);
			}

		}

		bw.close();
	}

}