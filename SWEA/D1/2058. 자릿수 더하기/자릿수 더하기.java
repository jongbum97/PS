import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);


			char[] ch = sc.next().toCharArray();
			
			
			int ans = 0;
			for(int i=0; i<ch.length; i++){
				ans += ch[i]-'0';
			}
			
			

			System.out.println(ans);

	}
}
