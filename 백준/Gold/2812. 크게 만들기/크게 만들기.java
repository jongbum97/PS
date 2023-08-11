import java.io.*;
import java.util.*;

public class Main {
	
	static int N, K;
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		char[] c = br.readLine().toCharArray();
		
		stack.add(c[0]-'0');
		
		for (int i = 1; i < N; i++) {
			int k = c[i]-'0';
			
			while (!stack.isEmpty() && stack.peek()<k && K>0) {
				stack.pop();
				K--;
			}
			
			stack.add(k);
			
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < stack.size()-K; i++) {
			sb.append(stack.get(i));
		}
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write(sb.toString());
		bw.close();
	}

}