import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] triangle, ans;
	static int n;

	public static void main(String[] args) throws IOException{

		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(bf.readLine());
		triangle = new int[n][];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(bf.readLine());
			triangle[i] = new int[i+1];
			for (int j = 0; j < i+1; j++) {
				triangle[i][j] = Integer.parseInt(st.nextToken());
			}
		} 
		
		
		ans = new int[n][];
		ans[0] = new int[1];
		ans[0][0] = triangle[0][0];
		for (int i = 1; i < n; i++) {
			ans[i] = new int[n+1];
			Arrays.fill(ans[i], -1);
			for (int j = 0; j < i+1; j++) {
				if (j==0) {
					ans[i][j] = ans[i-1][j] + triangle[i][j];
				}else if(j==i){
					ans[i][j] = ans[i-1][j-1] + triangle[i][j];
				}else {
					ans[i][j] = Math.max(ans[i-1][j-1], ans[i-1][j]) + triangle[i][j];
				}
			}
		}
		if (n==1) {
			bw.write(ans[0][0]+"\n");
		}else {
			Arrays.sort(ans[n-1]);
			bw.write(ans[n-1][n]+"\n");
		}
		bw.close();
	}	
		
}
