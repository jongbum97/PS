import java.io.*;
import java.util.*;

public class Main {

	static int N, nums[], dp[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nums = new int[N];
		for(int i=0; i<N; i++){
			nums[i] = Integer.parseInt(st.nextToken());
		}

		int size = 1;
		dp = new int[N];
		dp[0] = nums[0];
		for(int i=1; i<N; i++){
			if(dp[size-1] < nums[i]){
				dp[size++] = nums[i];
			} else if(dp[size-1] > nums[i]){
				int idx = Arrays.binarySearch(dp, 0, size, nums[i]);
				if(idx < 0){
					dp[-(idx+1)] = nums[i];
				}
			}
		}

		System.out.println(size);

	}

}
