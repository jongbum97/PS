import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int k = sc.nextInt();
			Stack<Integer> st = new Stack<>();
			for(int i=0; i<k; i++){
				int a = sc.nextInt();
				if(a!=0){
					st.add(a);
				}else {
					st.pop();
				}
			}
			int ans = 0;
			for(int i=0; i<st.size(); i++){
				ans += st.get(i);
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
