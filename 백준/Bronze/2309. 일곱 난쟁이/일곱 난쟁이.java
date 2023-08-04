import java.io.*;
import java.util.*;

public class Main {

	static int N, h[];
	static boolean[] b, d;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		h = new int[9];
		for (int i = 0; i < 9; i++) {
			h[i] = Integer.parseInt(br.readLine());
		}
		b = new boolean[9];
		d = new boolean[9];
		
		aaa(0, 0, 0);
		
		int[] cc = new int[7];
		int c = 0;
		for (int i = 0; i < 9; i++) {
			if (d[i]) {
				cc[c++]=h[i];
			}
		}
		Arrays.sort(cc);
		for (int i : cc) {
			System.out.println(i);
		}
		bw.close();
	}
	
	
	
	static void aaa(int n, int m, int sum) {
		
		if (sum>100) {
			return;
		}
		
		if (n==7) {
			if (sum==100) {
				d=b.clone();
			}
			return;
		}
		
		for (int i = m; i < 9; i++) {
			b[i] = true;
			aaa(n+1, i+1, sum+h[i]);
			b[i] = false;
		}
		
		
		
	}
	

}