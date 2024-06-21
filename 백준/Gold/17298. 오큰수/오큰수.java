import java.io.*;
import java.util.*;

public class Main {

	static int N, nums[], ans[];

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		ans = new int[N];
		Arrays.fill(ans, -1);
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());

		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		for (int i=1; i<N; i++){
			if(nums[i] > nums[stack.peek()]){
				while(!stack.isEmpty() && nums[i] > nums[stack.peek()] ){
					int idx = stack.pop();
					ans[idx] = nums[i];
				}
			}
			stack.push(i);
		}

		for (int i=0; i<N; i++){
			sb.append(ans[i]).append(" ");
		}
		System.out.println(sb.toString());

	}

}
