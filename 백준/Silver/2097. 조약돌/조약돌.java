import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long ans = 40000000000000L;
		if(N<=4) {
			System.out.println(4);
			return;
		}
		for (int i = 2; i <= Math.sqrt(N); i++) {
			int M = N/i;
			if(M*i<N) M++;
			ans = Math.min(ans, 2*(i+M-2));
		}
		
		System.out.println(ans);
		
	}

	
}