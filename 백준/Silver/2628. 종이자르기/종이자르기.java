import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int N = sc.nextInt();
		int[] dx = new int[x];
		int[] dy = new int[y];
		for(int i=0; i<N; i++) {
			int a = sc.nextInt();
			if(a==0){
				dy[sc.nextInt()]++;
			}else {
				dx[sc.nextInt()]++;
			}
		}
		
		int x_max = 0;
		int y_max = 0;
		int idx = 0;
		for(int i=0; i<x; i++) {
			if(dx[i]==0){
				idx++;
			}else {
				x_max = Math.max(x_max, idx);
				idx = 1;
			}
			if(i==x-1){
				x_max = Math.max(x_max, idx);
			}
		}
		idx = 0;
		for(int i=0; i<y; i++) {
			if(dy[i]==0){
				idx++;
			}else {
				y_max = Math.max(y_max, idx);
				idx = 1;
			}
			if(i==y-1){
				y_max = Math.max(y_max, idx);
			}
		}
		
		
		System.out.println(x_max*y_max);
		
		
	}
}