import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			
			long N = Long.parseLong(br.readLine());
			int two = 0;
			int five = 0;
			for (int i = 2; i <= N; i*=2) {
				two += N/i;
			}
			for (int i = 5; i <= N; i*=5) {
				five += N/i;
			}
			sb.append(Math.min(two, five)).append("\n");
		}
		System.out.println(sb);
		
	}

	
}