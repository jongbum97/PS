import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		outer : for (int i = (int)Math.pow(10, N-1)*2; i < (int)Math.pow(10, N) ; ) {
			
			for (int j = 0; j < N; j++) {
				int t = (i/(int)Math.pow(10, N-j-1));
				int count = 1+j;
				while (t>0) {

					for (int k = 2; k <= (int)Math.sqrt(t); k++) {
						if (t%k==0) {
							i += Math.pow(10, N-count);
							continue outer;
						}
					}
					count++;
					t /= 10;
				}
			}
			
			System.out.println(i++);
		}
		
		
	}
	
	
	
}