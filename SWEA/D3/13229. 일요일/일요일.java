import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			String day = sc.next();
			String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
			
			int ans = 0;
			for(int i=0; i<7; i++){
				if(day.equals(days[i])){
					ans = 7-i;
				}
			}
			System.out.println("#"+tc+" "+ans);
		}
	}
}
