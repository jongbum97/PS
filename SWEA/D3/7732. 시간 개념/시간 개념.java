import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {

			char[] cT = sc.next().toCharArray();
			char[] aT = sc.next().toCharArray();
			
			int cs = Integer.parseInt(cT[0]+""+cT[1])*3600 + Integer.parseInt(cT[3]+""+cT[4])*60 + Integer.parseInt(cT[6]+""+cT[7]);
			int as = Integer.parseInt(aT[0]+""+aT[1])*3600 + Integer.parseInt(aT[3]+""+aT[4])*60 + Integer.parseInt(aT[6]+""+aT[7]);
			
			int ans = 0;
			if(as>=cs){
				ans = as-cs;
			}else {
				ans = 86400-cs+as;
			}
			
			int[] t = new int[3];
			t[0] = ans/3600;
			ans %= 3600;
			t[1] = ans/60;
			ans %= 60;
			t[2] = ans;
			
			String[] time = new String[3];
			for(int i=0; i<3; i++){
				if(t[i]<10){
					time[i]="0"+t[i];
				}else {
					time[i]=t[i]+"";
				}
			}
			
			
			
			
			
			
			System.out.println("#"+tc+" "+time[0]+":"+time[1]+":"+time[2]);
			
		}
	}
	

}
