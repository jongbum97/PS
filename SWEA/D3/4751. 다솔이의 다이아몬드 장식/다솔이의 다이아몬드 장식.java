import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[] word = sc.next().toCharArray();
			int N = word.length;
			
			for(int i=0; i<N; i++){
				System.out.print("..#.");
			}
			System.out.println(".");
			
			for(int i=0; i<N; i++){
				System.out.print(".#.#");
			}
			System.out.println(".");
			
			for(int i=0; i<N; i++){
				System.out.print("#."+word[i]+".");
			}
			System.out.println("#");
			
			for(int i=0; i<N; i++){
				System.out.print(".#.#");
			}
			System.out.println(".");
			
			for(int i=0; i<N; i++){
				System.out.print("..#.");
			}
			System.out.println(".");
		}

	}
}
