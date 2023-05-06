import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int[] points = {0, 4, 4, 4, 4, 4, 4, 4, 4, 16, 4};
			int avg = 21;
			int N = sc.nextInt();
			int[] card = new int[N];
			for(int i=0; i<N; i++){
				card[i] = sc.nextInt();
				if(card[i]==1){
					points[10]--;
				}else if (card[i]>9) {
					points[9]--;
				}else {
					points[card[i]-1]--;
				}
				avg -= card[i];
			}
			
			for (int e : points) {
			}
			
			
			String ans = "STOP";
			Float count = (52f-N)/2;
			
			for(int i=0; i<11; i++){
				if((i+1)<=avg){
					count-=points[i];
					if(count<0){
						ans = "GAZUA";
						break;
					}
				}else {
					break;
				}
			}
			
			
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	

}
