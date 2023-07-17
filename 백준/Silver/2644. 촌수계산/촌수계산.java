import java.math.BigInteger;
import java.util.*;

public class Main {
	
	static int n, a, b, m, d, ans;
	static int[][] field;
	static boolean visit[];
	
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		a = sc.nextInt();
		b = sc.nextInt();
		m = sc.nextInt();
		d=0;
		ans = -1;
		field = new int[n+1][n+1];
		visit = new boolean[n+1];
		for(int i=0; i<m; i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			field[x][y]++;
			field[y][x]++;
		}
		
		BFS(a);
		
		System.out.println(ans);
		
		
		
		
		
	}
	
	static void BFS(int x) {
		visit[x] = true;
		if(x==b){
			ans = d;
			return;
		}
		for(int i=0; i<field[x].length; i++){
			if(field[x][i]==1 && !visit[i]){
				d++;
				BFS(i);
			}
		}
		d--;
	}
	
}