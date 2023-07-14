import java.util.*;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int L = sc.nextInt();
		int[] position = new int[1001];
		for (int i = 0; i < N; i++) {
			position[sc.nextInt()]++;
		}
		
		int ans = 0;
		int tape = 0;
		for (int i = 0; i < 1001; i++) {
			if (position[i] == 0) {
				tape--;
			}else {
				if (tape<1) {
					ans++;
					tape = L-1;
				}else {
					tape--;
				}
			}
		}
		
		System.out.println(ans);
		
	}

}
