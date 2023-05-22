import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			
			char[] ch = sc.next().toCharArray();
			int[][] cards = new int[4][14];
			char[] sdhc = {'S', 'D', 'H', 'C'};
			
			int ans = 0;
			outer : for(int i=0; i<ch.length; i+=3){
				for(int j=0; j<4; j++){
					if(ch[i]==sdhc[j]){
						if(cards[j][Integer.parseInt(ch[i+1]+""+ch[i+2])]>0){
							ans = -1;
							break outer;
						}else {
							cards[j][Integer.parseInt(ch[i+1]+""+ch[i+2])]++;
						}
					}
				}
			}
			
			if(ans==-1){
				System.out.println("#"+tc+" "+"ERROR");
			}else {
				System.out.print("#"+tc);
				for(int i=0; i<4; i++){
					int k = 13;
					for(int j=0; j<14; j++){
						if(cards[i][j]>0){
							k--;
						}
					}
					System.out.print(" "+k);
				}
				System.out.println();
			}
			
			
			
			
			
			
			
			
			
		}
	}
}
