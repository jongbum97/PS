import java.io.*;
import java.util.*;

public class Main {

	static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0){
			N = Integer.parseInt(br.readLine());
			sb.append(N/2+1).append("\n");
			Queue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
			Queue<Integer> right = new PriorityQueue<>();
			for(int i=0; i<=(N-1)/10; i++){
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<Math.min(10, N-10*i); j++){
					int n = Integer.parseInt(st.nextToken());

					if(!right.isEmpty() && right.peek() < n)
						right.add(n);
					else
						left.add(n);

					if(left.size() - right.size() > 1)
						right.add(left.remove());
					if(right.size() - left.size() >= 1)
						left.add(right.remove());

					if(j % 2 == 0)
						sb.append(left.peek()).append(" ");
				}
				if(i%2 == 1 )
					sb.append("\n");
			}
			if(N%19 != 0)
				sb.append("\n");
		}

		System.out.print(sb);

	}

}
