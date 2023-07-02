import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] trees = new int[N];
		for(int i=0; i<N; i++){
			trees[i] = sc.nextInt();
		}
		Arrays.sort(trees);
		int idx = 1;
		int sol = 0;
		for(int i=N-1; i>=0; i--){
			idx--;
			idx = Math.max(idx, trees[i]);
			sol++;
		}
		System.out.println(sol+idx+1);
		
	}
}