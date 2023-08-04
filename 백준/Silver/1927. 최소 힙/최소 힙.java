import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
	
	static int N;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		PriorityQueue<BigInteger> q = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			BigInteger b = new BigInteger(br.readLine());
			if (b.equals(BigInteger.ZERO)) {
				if (q.isEmpty()) {
					bw.write(0+"\n");
				}else {
					bw.write(q.remove()+"\n");
				}
			}else {
				q.add(b);
			}
		}
		bw.close();
		
		
		
		
	}
	
	
}