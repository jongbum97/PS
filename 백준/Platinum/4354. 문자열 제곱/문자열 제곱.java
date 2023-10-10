import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		char[] pattern;
		int N, idx;
		int[] table;
		while(!s.equals(".")) {
			
			pattern = s.toCharArray();
			N = pattern.length;
			table = new int[N];
			
			idx = 0;
			for (int i = 1; i < N; i++) {
				
				while (idx>0 && pattern[i] != pattern[idx]) {
					idx = table[idx-1];
				}
				
				if(pattern[i] == pattern[idx]) {
					table[i] = ++idx;
				}
				
			}
//			sb.append(Arrays.toString(table)).append("\n");
			
			if (N % (N - table[N-1]) != 0) {
                sb.append("1\n");
            } else {
                sb.append(N / (N-table[N-1]) + "\n");
            }
						
			
			s = br.readLine();
		}
		
		System.out.print(sb.toString());
	}
	

}