import java.io.*;
import java.util.*;

public class Main {

	static int N, nums[][], ab[], cd[];
	static long ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N][4];
		ab = new int[N*N];
		cd = new int[N*N];
		for(int i=0; i<N; i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++){
				nums[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++){
			for(int j=0; j<N; j++){
				ab[i*N+j] = nums[i][0] + nums[j][1];
				cd[i*N+j] = nums[i][2] + nums[j][3];
			}
		}
		Arrays.sort(ab);
		Arrays.sort(cd);

		int left = 0;
		int right = N * N - 1;

		while(left < N*N && right >= 0){
			int sum = ab[left] + cd[right];
			if(sum > 0){
				right--;
			}else if(sum < 0){
				left++;
			}else{
				int abCnt = 1;
				int cdCnt = 1;
				while(left+1 < N*N && ab[left] == ab[left+1]){
					abCnt++;
					left++;
				}
				while(right-1 >= 0 && cd[right] == cd[right-1]){
					cdCnt++;
					right--;
				}
				ans += (long) abCnt * cdCnt;
				left++;
				right--;
			}
		}
		
		System.out.println(ans);

	}


}
