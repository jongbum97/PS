import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] link;
	static int[] fects;
	static int flag = 1;
	static int count = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		link = new int[M][2];
		fects = new int[N];
		fects[0] = 1;
		for(int i=0; i<M; i++){
			link[i][0]=sc.nextInt();
			link[i][1]=sc.nextInt();
		}
		
		while(flag==1){
			flag=0;
			for(int i=0; i<N; i++){
				if(fects[i]==1){
					infect(i+1);
				}
			}
		}
		
		for(int i=0; i<N; i++){
			if(fects[i]==1){
				count++;
			}
		}
		
		System.out.println(count-1);
		
	}
	
	
	static void infect(int n) {
		for(int i=0; i<M; i++){
			if(link[i][0]==n){
				if(fects[link[i][1]-1]==0){
					fects[link[i][1]-1]=1;
				flag=1;
				}
			}else if (link[i][1]==n) {
				if(fects[link[i][0]-1]==0){
					fects[link[i][0]-1]=1;
				flag=1;
				}
			}
		}
	}
}
