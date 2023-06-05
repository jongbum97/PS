import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			char[] ch = sc.next().toCharArray();
			String y = ch[0]+""+ch[1]+ch[2]+ch[3];
			String m = ch[4]+""+ch[5];
			String d = ch[6]+""+ch[7];
			int yi = Integer.parseInt(y);
			int mi = Integer.parseInt(m);
			int di = Integer.parseInt(d);
			
			int[] ms = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
			int flag = 0;
			if(mi>12 || di>ms[mi]){
				flag = 1;
			}
			if(flag == 0){
				System.out.println("#"+tc+" "+y+"/"+m+"/"+d);
			}else {
				System.out.println("#"+tc+" "+(-1));
			}
			
			

		}
	}
}
