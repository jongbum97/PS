import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			
			char c0 = Character.toUpperCase(sc.next().charAt(0));
			char c1 = Character.toUpperCase(sc.next().charAt(0));
			char c2 = Character.toUpperCase(sc.next().charAt(0));
			
			String ans = c0+""+c1+c2;
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
