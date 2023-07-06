import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int[] cups = new int[3];
		int ball = 1;
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			if (a==ball) {
				ball = b;
			}else if(b==ball) {
				ball = a;
			}
		}
		
		System.out.println(ball);

	}
}