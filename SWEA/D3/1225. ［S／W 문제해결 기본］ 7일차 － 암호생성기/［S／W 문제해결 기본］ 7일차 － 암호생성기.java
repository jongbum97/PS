import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		for (int tc = 1; tc <= 10; tc++) {
			br.readLine();
			
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			outer : while (true) {
				for (int i = 1; i <= 5; i++) {
					int k = q.remove()-i;
					if (k<=0) {
						q.add(0);
						break outer;
					}else {
						q.add(k);
					}
				}
			}
			
			bw.write("#"+tc);
			for (int i = 0; i < 8; i++) {
				bw.write(" "+q.remove());
			}
			bw.write("\n");
			
		}
		
		bw.close();
	
	}


}