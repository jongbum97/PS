import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			String[] str = new String[N];
			for(int i=0; i<N; i++){
				str[i] = sc.next();
			}
			
			StringBuilder sb = new StringBuilder();
			if(N%2==0){
				for(int i=0; i<N/2; i++){
					sb.append(" "+str[i]);
					sb.append(" "+str[N/2+i]);
				}
			}else {
				for(int i=0; i<N/2; i++){
					sb.append(" "+str[i]);
					sb.append(" "+str[N/2+i+1]);
				}
				sb.append(" "+str[N/2]);
			}
			
			System.out.print("#"+tc);
			System.out.println(sb);
			
			
		}
	}
}
