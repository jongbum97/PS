import java.util.Scanner;

public class Solution {
	
	static int bread, time;
	static String ans;
	public static void main(String args[]) throws Exception{
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc=0; tc<T; tc++){
			bread = 0;
			time = 0;
			ans = "Impossible";
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[] visit = new int [11113];
			for(int i=0; i<N; i++){
				visit[sc.nextInt()]++;
			}
			
			//풀이시작
			fish(visit, M, K);
			System.out.println("#"+(tc+1)+" "+ans);
		}
	}
	
	public static void fish(int[] visit, int M, int K) {
		if(time>11112){
			ans = "Possible";
			return;
		}
		
		
		if(time%M==0 && time>0){
			bread += K;
		}
		if(visit[time]!=0){
			bread -= visit[time];
			if(bread<0){
				return;
			}
		}
		
		
		time++;
		fish(visit, M, K);
		
		
	}
	
	
}