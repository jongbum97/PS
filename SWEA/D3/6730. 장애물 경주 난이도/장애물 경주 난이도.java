import java.util.*;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] road = new int[N];
			for(int i=0; i<N; i++){
				road[i] = sc.nextInt();
			}
			
			int uphill = 0;
			int downhill = 0;
			
			for(int i=0; i<N-1; i++){
				if(road[i]<=road[i+1]){
					uphill = Math.max(uphill,road[i+1]-road[i]);
				}else {
					downhill =  Math.max(downhill,road[i]-road[i+1]);
				}
			}
			
			

			System.out.println("#" + tc + " "+uphill+" "+downhill);
			
		}

	}
}
