import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] nums = new int[N+1];
		for (int i = 1; i <= N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nums);
//		System.out.println(Arrays.toString(nums));
		int sum = 0;
		for (int i = 0; i <= N; i++) {
			if(sum>=nums[i]-1) {
				sum += nums[i];
			}else {
				break;
			}
		}
		
		System.out.println(sum+1);
		
	}


}
