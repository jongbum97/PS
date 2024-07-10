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

		dp = new int[N];
		dp[0] = nums[0];
		int size = 1;

		for(int i=1; i<N; i++){
			int idx = -(Arrays.binarySearch(dp, 0, size, nums[i])+1);
			dp[idx] = nums[i];
			if(idx == size) size++;
		}

		System.out.println(size);

	}

}
