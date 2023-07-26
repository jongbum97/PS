import java.util.*;
import java.io.*;

public class Main {

	static long N;
	static int P, Q, T;
	static int[] ans;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Long.parseLong(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		T = 10000000;
		ans = new int[T];
		ans[0]=1;
		ans[1]=2;
		bw.write(function(N)+"\n");;
		bw.close();
		
	}
	
	static long function(long n) {
		
		if (n<T) {
			int k = (int)n;
			if (ans[k] != 0) {
				return ans[k];
			}
			
			return ans[k] = (int) (function((int)Math.floor(k/P)) + function((int)Math.floor(k/Q)));
		}
		
		
		return function((long)Math.floor(n/P)) + function((long)Math.floor(n/Q)) ;
		
	}

}