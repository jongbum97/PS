import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] temperature = new int[N];
		for (int i = 0; i < N; i++) {
			temperature[i] = sc.nextInt();
		}
		int m = -999999999;
		for (int i = 0; i < N-K+1; i++) {
			int n = 0;
			for (int j = i; j < i+K; j++) {
				n += temperature[j];
			}
			m = Math.max(m, n);
		}
		
		System.out.println(m);
		
		
	}

}
