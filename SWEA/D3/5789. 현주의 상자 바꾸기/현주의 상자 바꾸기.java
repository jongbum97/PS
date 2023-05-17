import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int[] box = new int[N];
			for(int i=0; i<Q; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				for(int j=a-1; j<=b-1; j++){
					box[j]=i+1;
				}
			}
			
			
			System.out.print("#"+tc);
			for (int e : box) {
			System.out.print(" "+e);	
			}
			System.out.println();
			
		}
	}
	

}
