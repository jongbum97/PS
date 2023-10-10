import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = br.readLine();
		String s2 = br.readLine();
		char[] parent = s1.toCharArray();
		char[] pattern = s2.toCharArray();
		int N = parent.length;
		int M = pattern.length;
		
		int[] table = makeTable(s2);
//		for (int i = 0; i < M; i++) {
//			outer : for (int j = i-1; j >= 0; j--) {
//				for (int k = 0; k <= j; k++) {
//					if(pattern[i-j+k]!=pattern[k]) continue outer;
//				}
//				table[i] = j+1;
//				break;
//			}
//		}
		
//		System.out.println(Arrays.toString(table));
		
		int ans = 0;
		int idx = 0;
		for (int i = 0; i < N; i++) {
			if(parent[i]==pattern[idx]) {
				idx++;
			}else {
				if(idx>0) {
					i--;
					idx = table[idx-1];
				}
			}
			if(idx==M) {
				ans++;
				sb.append(i-M+2).append(" ");
				idx = table[idx-1];
			}
		}
		
		System.out.println(ans);
		System.out.println(sb.toString());

		
	}
	
	static int[] makeTable(String pattern) {
		int n = pattern.length();
		int[] table = new int[n];
			
		int idx=0;
		for(int i=1; i<n; i++) {
			while(idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
				idx = table[idx-1];
			}
				
			if(pattern.charAt(i) == pattern.charAt(idx)) {
				idx += 1;
				table[i] = idx;  
			}
		}
		return table;
	}

}