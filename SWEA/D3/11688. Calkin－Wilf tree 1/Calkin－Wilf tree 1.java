import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			char[] tree = sc.next().toCharArray();
			
			int A = 1;
			int B = 1;
			for(int i=0; i<tree.length; i++){
				if(tree[i]=='L'){
					B += A;
				}else {
					A += B;
				}
			}
		
			System.out.println("#"+tc+" "+A+" "+B);
			
		}
	}
	

}
