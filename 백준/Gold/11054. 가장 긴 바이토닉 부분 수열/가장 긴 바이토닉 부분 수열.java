import java.util.*;
import java.io.*;

public class Main {

	static int[] nums, up, down;
	static int N, max;

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		up = new int[N];
		down = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		up[0] = 1;
		for (int i = 1; i < N; i++) {
			up[i] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i]>nums[j]) {
					up[i] = Math.max(up[i], up[j]+1);
				}
			}
		}
		
		down[N-1] = 1;
		for (int i = N-2; i >= 0; i--) {
			down[i] = 1;
			for (int j = N-1; j > i; j--) {
				if (nums[i]>nums[j]) {
					down[i] = Math.max(down[i], down[j]+1);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			max = Math.max(max, up[i]+down[i]);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write((max-1)+"\n");
		bw.close();
		
		
		
	}
	

}