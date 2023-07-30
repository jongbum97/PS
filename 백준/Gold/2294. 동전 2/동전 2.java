import java.io.*;
import java.util.*;

public class Main {
	
	static int[] ans, value;
	static int n, k;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		value = new int[n+1];
		ans = new int[k+1];
		Arrays.fill(ans, 100000000);
		ans[0] = 0;
		for (int i = 1; i <= n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				if (i-value[j]<0) {
					continue;
				}
				ans[i] = Math.min(ans[i], ans[i-value[j]]+1);
			}
		}
		if (ans[k]==100000000) {
			bw.write(-1+"\n");
		}else {
			bw.write(ans[k]+"\n");
		}
		bw.close();
		
		
		
		
		
	}	
		
}
