import java.io.*;
import java.util.*;

public class Main {
	
	static int N, value[], ans;
	static char[][] words;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		words = new char[N][N];
		value = new int[26];
		
		for (int i = 0; i < N; i++) {
			words[i] = br.readLine().toCharArray();
			int M = words[i].length;
			for (int j = 0; j < M; j++) {
				value[words[i][j]-'A'] += Math.pow(10, M-1-j);
			}
		}
		
		for (int i = 9; i >= 0; i--) {
			int maxIdx = 0;
			for (int j = 1; j < 26; j++) {
				if(value[maxIdx]<value[j]) maxIdx = j;
			}
			if(value[maxIdx]==0) break;
			ans += i*value[maxIdx];
			value[maxIdx] = 0;
		}
		
		System.out.println(ans);
		
		
	}

}