import java.io.*;
import java.util.*;

public class Main {
	
	static int[] ans;
	static int n;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		n = Integer.parseInt(br.readLine());
		if ((n%2)!=0) {
			bw.write(0+"\n");
			bw.close();
			return;
		}
		ans = new int[n+1];
		ans[2] = 3;
		for (int i = 4; i <= n; i+=2) {
			ans[i] = ans[i-2]*3 + 2;
			for (int j = 2; j < i-2 ; j+=2) {
				ans[i] += ans[j]*2;
			}
		}
		
		
		
		bw.write(ans[n]+"\n");
		bw.close();
		
		
		
		
		
	}	
		
}
