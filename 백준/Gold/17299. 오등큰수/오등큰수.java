import java.io.*;
import java.util.*;

public class Main {

	static int N, cnt[], nums[], ans[], firstIdx[];
	static final int MAX_VALUE = 1_000_001;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		cnt = new int[MAX_VALUE];
		firstIdx = new int[MAX_VALUE];
		Arrays.fill(firstIdx, -1);
		nums = new int[N];
		ans = new int[MAX_VALUE];
		for(int i=0; i<N; i++){
			cnt[nums[i] = Integer.parseInt(st.nextToken())]++;
			if(firstIdx[nums[i]] == -1){
				firstIdx[nums[i]] = i;
			}
		}

		Deque<Integer> stack = new ArrayDeque<>();
		for(int i=0; i<N; i++){
			while(!stack.isEmpty() && cnt[nums[stack.peek()]] < cnt[nums[i]]) {
				ans[stack.pop()] = nums[i];
			}

			stack.push(i);
		}
		while(!stack.isEmpty()){
			ans[stack.pop()] = -1;
		}
		for(int i=0; i<N; i++){
			sb.append(ans[i]).append(" ");
		}
		sb.append("\n");

		System.out.println(sb);

	}


}
