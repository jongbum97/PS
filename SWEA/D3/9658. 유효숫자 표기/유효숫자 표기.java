import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			String N = sc.next();
			int k = N.length()-1;
			Double num = Integer.parseInt(N.charAt(0)+""+N.charAt(1)+N.charAt(2))/100.0;

			num = Math.round(num*10)/10.0;

			if(num==10.0){
				num /= 10;
				k++;
			}
			System.out.println("#"+tc+" "+num+"*10^"+k);
			
		}
	}
	

}
