import java.io.*;
import java.util.*;

public class Solution {
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for (int tc = 1; tc <= 10; tc++) {
			List<Integer> list = new LinkedList<>();
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				st.nextToken();
				int k = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				int[] idx = new int[m];
				for (int j = 0; j < m; j++) {
					idx[j] = Integer.parseInt(st.nextToken());
				}
				for (int j = m-1; j >=0; j--) {
					list.add(k, idx[j]);
				}
			}
			
			bw.write("#"+tc);
			int p = list.size();
			if(p>10) p=10;
			for (int i = 0; i < p; i++) {
				bw.write(" "+list.get(i));
			}
			bw.write("\n");
			
			
		}
		bw.close();
		
		
	}

}
