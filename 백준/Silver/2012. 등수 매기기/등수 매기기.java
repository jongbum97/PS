import java.util.*;

public class Main {
	
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] person = new int[N];
		for (int i = 0; i < N; i++) {
			person[i] = sc.nextInt();
		}
		
		Arrays.sort(person);
		long ans = 0;
		for (int i = 0; i < N; i++) {
			ans += Math.abs(i+1-(person[i]));
		}
		System.out.println(ans);
		
	}
	
}
