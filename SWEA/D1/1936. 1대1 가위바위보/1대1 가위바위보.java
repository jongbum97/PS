import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			String ans = "B";
			if(a==1){
				if(b==3) ans="A";
			}else if (a==2) {
				if(b==1) ans="A";
			}else {
				if(b==2) ans="A";
			}
			
			
			System.out.println(ans);

	}
}
