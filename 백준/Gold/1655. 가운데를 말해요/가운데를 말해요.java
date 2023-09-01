import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> q1 = new PriorityQueue<>((a, b)->b-a);
		PriorityQueue<Integer> q2 = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			int M = Integer.parseInt(br.readLine());
			
			if(q1.isEmpty()) q1.add(M);
			else if(q1.peek()>=M) q1.add(M);
			else q2.add(M);
			
			if(q1.size()-q2.size()>1) {
				q2.add(q1.remove());
			}else if (q2.size()-q1.size()>1) {
				q1.add(q2.remove());
			}
			
			if (q2.size()>q1.size()) sb.append(q2.peek()).append("\n");
			else sb.append(q1.peek()).append("\n");
			
		}
		
		System.out.println(sb);
		
	}

	
}