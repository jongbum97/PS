import java.io.*;
import java.util.*;

public class Main {
	
	static long N, K, P=1000000007;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		long t = (factorial(N-K)*factorial(K))%P;
		System.out.println((factorial(N)*(pow(t,P-2)))%P);

	}
	
	static long factorial(long n) {
		long tmp = 1;
		for (int i = 2; i <= n; i++) {
			tmp *= i;
			tmp %= P;
		}
		return tmp;
	}
	
	static long pow(long n, long cnt) {
		
		if(cnt==1) return n;
		
		if(cnt%2 == 0) {
			long tmp = pow(n, cnt/2);
			return (tmp*tmp)%P;
		}else {
			long tmp = pow(n, (cnt-1)/2);
			return (((tmp*n)%P)*tmp)%P;
		}
		
	}

}