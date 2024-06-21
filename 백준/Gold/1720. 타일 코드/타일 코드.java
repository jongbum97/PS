import java.io.*;
import java.util.*;

public class Main {

	static int N, dp[], dp2[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		dp = new int[31];
		dp[1] = 1; dp[2] = 3;
		for(int i=3; i<31; i++){
			dp[i] = dp[i-2]*2 + dp[i-1];
		}

		dp2 = new int[31];
		dp2[1] = 1;
		dp2[2] = 3;
		for(int i=3; i<31; i++){
			if(i%2 == 0){
				dp2[i] = dp[i/2-1]*2 + dp[i/2];
			}else{
				dp2[i] = dp[i/2];
			}
		}

		System.out.println((dp[N]+dp2[N])/2);

	}

}
