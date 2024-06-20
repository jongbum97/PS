import java.io.*;
import java.util.*;

public class Main {

	static int N;
	static long ans;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		if(N == 0){
			System.out.println(0);
			return;
		}
		ans = -1;
		int cnt = 0;

		outer: for (long i=1; i<=9876543210L; i++){

			char[] nums = (i+"").toCharArray();

			for (int j=0; j<nums.length-1; j++){
				if(nums[j] <= nums[j+1]) {
					long k = (long)Math.pow(10, nums.length-j-1);
					i = ((i/k)+1)*k-1;
					continue outer;
				}
			}

			if(++cnt == N) {
				ans = i;
				break;
			}

		}

		System.out.println(ans);

	}


}
