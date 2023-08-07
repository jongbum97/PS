import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] ans = new int[N];
		int c = 0;
		
		
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.add(i);
		}
		
		while (!q.isEmpty()) {
			
			for (int i = 0; i < K-1; i++) {
				q.add(q.remove());
			}
			ans[c++] = q.remove();
			
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		bw.write("<"+ans[0]);
		for (int i = 1; i < N; i++) {
			bw.write(", "+ans[i]);
		}
		bw.write(">");
		bw.close();
	}
	
}